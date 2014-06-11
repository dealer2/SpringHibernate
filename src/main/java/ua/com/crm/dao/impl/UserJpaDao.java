package ua.com.crm.dao.impl;



import ua.com.crm.commons.dao.GenericJpaDao;
import ua.com.crm.dao.UserDao;
import ua.com.crm.entity.UserEntity;

/**
 * Data access object JPA impl to work with User entity database operations
 * 
 * @author dealer2
 *
 */

public class UserJpaDao extends GenericJpaDao<UserEntity, Long> implements UserDao{

	public UserJpaDao() {
		super(UserEntity.class);
	}



}
