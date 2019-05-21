package bookStoreWebsite;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bookstore.entity.Users;

public class UsersTest {

	public static void main(String[] args) {
		
		Users user= new Users();
		user.setFirstName("mahima");
		user.setLastName("Bhatnagar");
		user.setEmail("Vaibhavabc@doctor.com");
		user.setPassword("doc");
		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("bookStroreWebsite");
		EntityManager entityManager = createEntityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
		createEntityManagerFactory.close();
		
		System.out.println("User object was persisted!!");
	
	
	}

}
