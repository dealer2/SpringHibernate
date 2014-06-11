package ua.com.crm.commons.dao;

import java.io.Serializable;
import java.util.List;


/**
 * Generic interface for Data Access Object. To be extended or implemented
 * Contains common persist methods.
 * 
 * @author dealer 
 *
 */
public interface GenericDao <T, ID extends Serializable> {
	
	T save (T entity);
	T update (T entity);
	void delete (T entity);
	T findById (ID id);
	List <T> findAll ();
	void flush();
	
	

}
