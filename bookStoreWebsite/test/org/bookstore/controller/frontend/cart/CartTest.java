package org.bookstore.controller.frontend.cart;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.bookstore.entity.Book;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CartTest {
	
	private static ShoppingCart cart;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cart = new ShoppingCart();
		
		Book book = new Book(1);
		
		cart.addItem(book);
		cart.addItem(book);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddItem() {
		Map<Book, Integer> items = cart.getItems();
		
		int quantity = items.get(new Book(1));
		
		assertEquals(2,quantity);
	}
	
	@Test
	public void testRemoveItem() {
	}


}
