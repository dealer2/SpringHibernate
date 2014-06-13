package ua.com.crm.services.impl;



import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jetty.jndi.local.localContextRoot;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ua.com.crm.dao.UserDao;
import ua.com.crm.entity.UserEntity;
import ua.com.crm.services.UserService;

/**
 * Service providing service methods to work with user data and entity.
 * 
 * @author dealer2
 *
 */

public class UserServiceImpl implements UserService, UserDetailsService{

	
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
		return true;
	}
	
	

	/**
	 * Construct UserDetais instance required Spring Security 
	 * 
	 * @author dealer2
	 */
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity user = userDao.loadUserByUserName(userName);
		
		if (user==null){
		throw new UsernameNotFoundException(String.format("No such user with name '%s'", userName)); 	
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		User userDetails = new User(user.getUserName(), user.getPassword(), authorities);
		return userDetails;
	}



	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
