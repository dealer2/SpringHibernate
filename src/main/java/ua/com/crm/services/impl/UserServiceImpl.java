package ua.com.crm.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.crm.dao.UserDao;
import ua.com.crm.entity.UserEntity;
import ua.com.crm.services.UserService;

/**
 * Service providing service methods to work with user data and entity.
 * 
 * @author dealer2
 *
 */

public class UserServiceImpl implements UserService{

	
	private UserDao userDao;
	
	/**
	 * Create User - persist to database
	 * 
	 * @param userEntity
	 * @return true if success
	 */
	
	
	public boolean createUser(UserEntity userEntity) {
	
		/*UserEntity entity = new UserEntity();
		entity.setFirstName("Joe");
		entity.setLastName("Corman");
		entity.setUserName("Jorman");
		entity.setPassword("111");*/
		
		userDao.save(userEntity);
		userDao.flush();
		return true;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
