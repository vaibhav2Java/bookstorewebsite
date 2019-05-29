package org.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDAO<E> {
	private static EntityManagerFactory entityManagerFactory;
	
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("bookStoreWebsite");

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public JpaDAO() {

	}

	public E create(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}

	public E update(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;

	}

	public E find(Class<E> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		E entity = entityManager.find(type, id);
		if (entity != null) {
			entityManager.refresh(entity);

		}
		entityManager.close();
		return entity;
	}

	public void delete(Class<E> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Object refrence = entityManager.getReference(type, id);
		entityManager.remove(refrence);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<E> findwithNamedQuery(String queryname) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryname);
		List<E> resultList = query.getResultList();
		entityManager.close();
		return resultList;
	}
	
	public List<E> findwithNamedQuery(String queryname,String paramName, Object paramValue){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryname);
		query.setParameter(paramName, paramValue);
		List<E> resultList = query.getResultList();
		entityManager.close();
		return resultList;
	}
	
	public List<E> findwithNamedQuery(String queryname, Map<String, Object> parameter){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryname);
		Set<Entry<String,Object>> setParameter = parameter.entrySet();
		for (Entry<String, Object> entry : setParameter) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		List<E> resultList = query.getResultList();
		entityManager.close();
		return resultList;
	}
	public long countwithNamedQuery(String queryname) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryname);		
		long singleResult = (long) query.getSingleResult();
		entityManager.close();
		return singleResult;
	}
	public List<E> findwithNamedQuery(String queryName, int firstResult, int maxResult) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		query.setFirstResult(0);
		query.setMaxResults(4);
		List<E> resultList = query.getResultList();
		entityManager.close();
		return resultList;
	}
	
	public void close() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	} 
}
