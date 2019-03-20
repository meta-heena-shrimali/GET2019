package com.metacube.ead2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.ead2.database.MyConnectionManager;
import com.metacube.ead2.database.MyDatabaseQueries;
import com.metacube.ead2.enums.Status;

import com.metacube.ead2.model.Advertisement;

public class AdvertisementDao implements BaseDao<Advertisement> {

    private Connection con;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public List<Advertisement> getList() {

        List<Advertisement> advertisementList = new ArrayList<Advertisement>();
        try {
            con = MyConnectionManager.getConnection();
            query = MyDatabaseQueries.GET_ALL_ADVERTISEMENT;
            preparedStatement = con.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Advertisement advertisement = new Advertisement();
                advertisement.setId(resultSet.getInt(1));
                advertisement.setTitle(resultSet.getString(2));
                advertisement.setDescription(resultSet.getString(3));
                advertisementList.add(advertisement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return advertisementList;

    }

    @Override
    public Status insert(Advertisement entity) {

        try {
            con = MyConnectionManager.getConnection();
            query = MyDatabaseQueries.INSERT_ADVERTISEMENT;
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getTitle());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setInt(4, entity.getCategoryID());
            preparedStatement.executeUpdate();
            return Status.INSERTED;
        } catch (SQLException e) {
            return Status.ERROR;
        }

    }

    @Override
    public Status delete(int id) {
        try {
            con = MyConnectionManager.getConnection();
            query = MyDatabaseQueries.DELETE_ADVERTISEMENT;
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return Status.DELETED;
        } catch (SQLException e) {
            return Status.ERROR;
        }
    }

    @Override
    public Status update(Advertisement entity) {

        try {
            con = MyConnectionManager.getConnection();
            query = MyDatabaseQueries.UPDATE_ADVERTISEMENT;
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(3, entity.getId());
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.executeUpdate();
            return Status.UPDATED;
        } catch (SQLException e) {
            return Status.ERROR;
        }

    }

}
