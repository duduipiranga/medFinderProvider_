package com.medfinder.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.medfinder.dao.GenericDAO;
import com.medfinder.persistence.EntityManagerFactorySingleton;

public abstract class HibernateDAO<T, K> implements GenericDAO<T, K> {
	@PersistenceContext(unitName = "ORACLE")
	protected EntityManager em;
	private Class<T> entityClass;

	@SuppressWarnings("all")
	public HibernateDAO() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.em = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		em.getTransaction().begin();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {
		Query query = em.createQuery("from "+entityClass.getSimpleName());
		List<T> resultList = query.getResultList();
		em.close();
		return resultList;
	}
	
	@Override
	public void insert(T entity) {		
		
		try{
		em.persist(entity);
		em.getTransaction().commit();
		
		}catch(org.hibernate.HibernateException e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		
		
	}

	@Override
	public void removeById(K id) {
		T entity = em.find(entityClass, id);
		
		em.remove(em.merge(entity));
		em.getTransaction().commit();
		em.close();
	}
	

	@Override
	public void remove(T entity) {
	// para forçar a entidade ser gerenciada pelo em
		
		em.remove(em.merge(entity));
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public T find(K id) {
		return em.find(entityClass, id);
	}

	@Override
	public void update(T entity) {
		em.merge(entity);
		em.getTransaction().commit();
		em.close();
	}
}
