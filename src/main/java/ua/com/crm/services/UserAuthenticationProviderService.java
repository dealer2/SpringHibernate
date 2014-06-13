package ua.com.crm.services;

import ua.com.crm.entity.UserEntity;

/**
 * Provides processing service to set user authentication session  
 * 
 * @author dealer2
 *
 */

public interface UserAuthenticationProviderService {
	
	/**
	 * Process user authentication
	 * 
	 * @param user
	 * @return
	 */
	boolean processUserAuthentication (UserEntity user);

}
