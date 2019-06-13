package org.bookstore.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.bookstore.entity.Book;
import org.bookstore.entity.Customer;
import org.bookstore.entity.Review;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReviewDaoTest {
	
	private static ReviewDao reviewDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reviewDao = new ReviewDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDao.close();
	}


	@Test
	public void testCreateReview() {
		Book book = new Book();
		Customer customer = new Customer();
		Review reviews = new Review();
		book.setBookId(4);		
		customer.setCustomerId(14);
		reviews.setBook(book);
		reviews.setCustomer(customer);
		reviews.setHeadline("this is a good book");
		reviews.setRating(4);
		reviews.setComment("i have just read this book");
		Review create = reviewDao.create(reviews);
		System.out.println("review comment" +create.getComment());
		assertTrue(create.getReviewId()>0);
	}
	
	@Test
	public void testGet() {
		Integer id = 6;
		Review review = reviewDao.get(id);
		System.out.println(review.getCustomer().getFirstName());
		assertTrue(review.getCustomer().getFirstName().equals("Kamal"));
	}

	@Test
	public void testDeleteReview() {
		Review review = new Review();
		Integer id = 7;
		reviewDao.delete(id);
		List<Review> listAll = reviewDao.listAll();
		assertTrue(listAll.size() > 0 && listAll.size() == 3);
	}

	@Test
	public void testListAll() {
		List<Review> listAll = reviewDao.listAll();
		System.out.println(listAll.size());
		assertTrue(listAll.size() > 0 && listAll.size() == 4);
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}
	
	@Test
	public void findbyCustomerAndBook() {
		Integer customerId = 100;
		Integer bookId = 99;
		Review findbyCustomerAndBook = reviewDao.findbyCustomerAndBook(customerId, bookId);
		assertNull(findbyCustomerAndBook);
	}
	
	

}
