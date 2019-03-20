package com.metacube.ead2.dao;

import java.util.List;

import com.metacube.ead2.enums.Status;

public interface BaseDao<T> {

	/*
	 * Method to return the list of T objects
	 * @return list
	 */
	public List<T> getList();

	/*
	 * Method to insert new data into database
	 * 
	 * @param advertisement
	 * @return status
	 */
	public Status insert(T entity);

	/*
	 * Method to delete the data
	 * 
	 * @param id of the data
	 * @return status
	 */
	public Status delete(int id);

	/*
	 * Method to update data 
	 * 
	 * @param    generic data
	 * @param id of the advertisement
	 */
	public Status update(T entity);

}
