package org.bookstore.controller.frontend.cart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

	@Test
	public void testAddItem() {
		Map<Book, Integer> items = cart.getItems();
		int quantity = items.get(new Book(1));
		assertEquals(2,quantity);
	}
	
	@Test
	public void testAddItem1() {
		ShoppingCart cart = new ShoppingCart();
		Book book = new Book();
		book.setBookId(1);
		cart.addItem(book);
		cart.addItem(book);
		Map<Book, Integer> items = cart.getItems();
		int quantity = items.get(book);
		assertEquals(2,quantity);
	}
	

	
	@Test
	public void testRemoveItem() {
		
		cart.removeItem(new Book(1));
		
		assertTrue(cart.getItems().isEmpty());
		
	}

	@Test
	public void testgetTotalQuantity() {
		Book book3 = new Book();
		cart.addItem(book3);
		cart.addItem(book3);
		cart.addItem(book3);
		
		
		assertEquals(5, cart.getTotalQuantity());
	}

}
