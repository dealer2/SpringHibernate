package ua.com.crm.services;

import ua.com.crm.entity.UserEntity;


/**
 * Service providing service methods to work with user data and entity.
 *
 * @author dealer2
 *
 */


public interface UserService {

	/**
     * Create User - persist to database
     *
     * @param userEntity
     * @return true if success
     */
	public boolean createUser(UserEntity userEntity);

	
}