package org.bookstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bookstore.entity.Book;
import org.bookstore.entity.Category;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookDAOtest  extends BaseDaotest{
	
	private static BookDAO bookDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDaotest.setUpBeforeClass();
		bookDAO = new BookDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDaotest.tearDownAfterClass();


	}

	@Test
	public void testListAll() {
	}

	@Test
	public void testCreateBook() throws ParseException, IOException {
		Book newbook = new Book();
		Category category = new Category("JavaEE");
		category.setCategoryId(2);
		newbook.setCategory(category);
		newbook.setTitle("Java EE 7: The Big Picture (Programming & Web Dev - OMG)");
		newbook.setAuthor("Dr. Danny Coward");
		newbook.setDescription("The Big Picture uniquely explores the entire Java EE 7 platform in an all-encompassing style while examining each tier of the platform in enough detail so that you can select the right technologies for specific project needs. ");
		newbook.setPrice(37.18f);
		newbook.setIsbn("0071837345");
		DateFormat dateformat = new SimpleDateFormat("mm/dd/yyyy");
		String imagePath = "C:\\Users\\DELL\\Desktop\\full onine\\books\\Effective Java.JPG";
		byte[] readAllBytes = Files.readAllBytes(Paths.get(imagePath));
		newbook.setImage(readAllBytes);
		Date publicdate = dateformat.parse("06/28/2008");
		newbook.setPublishDate(publicdate);
		Book create1 = bookDAO.create(newbook);
		assertTrue(create1.getBookId()>0);
	}
	
	@Test
	public void SerchBookIntitle() {
		String keyword = "Java";
		List<Book> book = bookDAO.searchBook(keyword);
		assertEquals(0 ,book.size());
	}
	
	@Test
	public void TestListByCategory() {
		int categoryId=2;
		List<Book> listByCategory = bookDAO.listByCategory(categoryId);
		System.out.println("Size of listByCategory:" +listByCategory.size());
		assertTrue(listByCategory.size() > 0);
	}
}