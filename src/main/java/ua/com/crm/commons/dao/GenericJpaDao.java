package ua.com.crm.commons.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ua.com.crm.commons.entity.BaseEntity;


/**
 * Provides generic common implementation GenericDao interface persistence methods
 * Extend this abstract class to implement DAO for your specific needs.
 * 
 * @author dealer2
 *
 */
@Transactional
public abstract class GenericJpaDao<T, ID extends Serializable>  implements GenericDao<T, ID>{
	
	private Class<T> persistanceClass;
	
	private EntityManager entityManager;
	

	public GenericJpaDao(Class<T> persistanceClass){
		this.persistanceClass = persistanceClass;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getPersistanceClass() {
		return persistanceClass;
	}
	
	public T save(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	public T update(T entity) {
		T mergedEntity = getEntityManager().merge(entity);
		return mergedEntity;
	}

	public void delete(T entity) {
		if (BaseEntity.class.isAssignableFrom(persistanceClass)) {
			getEntityManager().remove(
					getEntityManager().getReference(entity.getClass(),
							((BaseEntity)entity).getId()));
		}
		
	}

	@Transactional(readOnly=true)
	public T findById(ID id) {
		T entity = (T) getEntityManager().find(getPersistanceClass(),id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findAll() {
		return getEntityManager()
				.createQuery("select x from " + getPersistanceClass().getSimpleName() + " x")
				.getResultList();
	}

	public void flush() {
		getEntityManager().flush();
		
	}
	
	
	
}
