package bookStoreWebsite;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bookstore.entity.Category;


public class CategoryTest {

	public static void main(String[] args) {
		Category newcat = new Category();
		newcat.setCategoryName("Advanced Java");
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("bookStroreWebsite");
		EntityManager entityManager = createEntityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(newcat);
		entityManager.getTransaction().commit();
		entityManager.close();
		createEntityManagerFactory.close();
		System.out.println("User object was persisted!!");
	}
}