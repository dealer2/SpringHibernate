package ua.com.crm.entity;


import java.io.Serializable;

import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import ua.com.crm.commons.entity.BaseEntity;


/**
 * Entity to hold application user data - first name, last name, user name etc.
 * 
 * @author dealer2
 *
 */

@SuppressWarnings("deprecation")
@Entity
@Table(name="appuser")
public class UserEntity extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 5116340352796156298L;
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		PasswordEncoder crypto = new Md5PasswordEncoder();
		this.password = crypto.encodePassword(password, null);
	}
	
	

}
