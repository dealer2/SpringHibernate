package ua.com.crm.dao.impl;



import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.util.Assert;

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

	@Override
	public boolean checkAvailable(String userName) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public UserEntity loadUserByUserName(String userName) {
		 Assert.notNull(userName);
        
        UserEntity user = null;
        
        Query query = getEntityManager().createQuery("select u from " + getPersistanceClass().getSimpleName()
                        + " u where u.userName = :userName").setParameter("userName", userName);
        
        try {
                user = (UserEntity) query.getSingleResult();
                
        } catch (NoResultException e) {
                // do nothing
        }
        return  user;
}



}
