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
		Category category = new Category("Advanced Java");
		category.setCategoryId(2);
		newbook.setCategory(category);
		newbook.setTitle("MyJava (2nd Edition)");
		newbook.setAuthor("Joshua Bloch");
		newbook.setDescription("Each chapter in the book consists of several “items” presented ");
		newbook.setPrice(38.87f);
		newbook.setIsbn("0321356683");
		DateFormat dateformat = new SimpleDateFormat("mm/dd/yyyy");
		
		String imagePath = "C:\\Users\\DELL\\Desktop\\full onine\\books\\Effective Java.JPG";
		byte[] readAllBytes = Files.readAllBytes(Paths.get(imagePath));
		newbook.setImage(readAllBytes);
		Date publicdate = dateformat.parse("05/28/2008");
		newbook.setPublishDate(publicdate);
		Book create1 = bookDAO.create(newbook);
		assertTrue(create1.getBookId()>0);

	
	}

}
