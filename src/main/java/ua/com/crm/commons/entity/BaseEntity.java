package ua.com.crm.commons.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base entity type to hold common id property. To be extended
 * 
 * @author dealer2
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -8918414339488423148L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
