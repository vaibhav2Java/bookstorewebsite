package org.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseDaotest {
	
	public static EntityManagerFactory entityManagerFactory;
	public static EntityManager entityManager;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory=Persistence.createEntityManagerFactory("bookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
	}
}