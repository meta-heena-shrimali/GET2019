package com.metacube.springMVC.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.metacube.springMVC.model.User;

@Repository
@Transactional
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

   
    public boolean add(User user) {
        try {
            sessionFactory.getCurrentSession().save(user);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

   
    public User get(Integer id) {

        try {
            Session session = sessionFactory.getCurrentSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            Root<User> user = query.from(User.class);
            query.select(user).where(criteriaBuilder.equal(user.get("id"), id));
            return session.createQuery(query).getSingleResult();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

   
    public List<User> getAll() {
        try {
            Session session = sessionFactory.getCurrentSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            Root<User> user = query.from(User.class);
            query.select(user);
            return session.createQuery(query).getResultList();
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    }

   
    public boolean update(User user) {
        try {
            sessionFactory.getCurrentSession().update(user);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

   
    public boolean delete(Integer id) {
        try {
            User user = get(id);
            sessionFactory.getCurrentSession().delete(user);
            return true;
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    

    public List<User> search(String searchBy, String userInfo) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> user = query.from(User.class);
        query.select(user).where(
                criteriaBuilder.equal(user.get(searchBy), userInfo));
        return session.createQuery(query).getResultList();
    }

}

