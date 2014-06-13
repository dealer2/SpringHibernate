package ua.com.crm.dao;

import ua.com.crm.commons.dao.GenericDao;
import ua.com.crm.entity.UserEntity;

/**
 * Data access object interface to work with User entity database operations
 * 
 * @author dealer2
 *
 */
public interface UserDao extends GenericDao<UserEntity, Long> {
	/**
     * Queries database for user name availability
     *
     * @param userName
     * @return true if available
     */
    public boolean checkAvailable(String userName);
    
    /**
     * Queries user by userName
     *
     * @param userName
     * @return User entity
     */
    
    public UserEntity loadUserByUserName (String userName);

	

}
