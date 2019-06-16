package org.bookstore.controller.frontend.cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bookstore.entity.Book;

public class ShoppingCart {
	private Map <Book,Integer> cart = new HashMap<>();
	
	public void addItem(Book book) {
		System.out.println("Calling is comming additem" +book.getTitle());
		if(cart.containsKey(book)) {
			Integer quantity = cart.get(book) + 1;
			cart.put(book, quantity);
		}else {
			cart.put(book, 1);
		}
	}
	
	public Map<Book, Integer> getItems(){
		return cart;
	}
	
	public void removeItem(Book book) {
		cart.remove(book);
	}
	
	public int getTotalQuantity() {
		int total= 0;
		
		Iterator<Book> iterator = cart.keySet().iterator();
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			Integer quantity = cart.get(book);
			total += quantity;
		}
		return total;
	}
	
	public double getTotalAmount() {
		double total= 0;
		
		Iterator<Book> iterator = cart.keySet().iterator();
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			Integer quantity = cart.get(book);
			double subTotal = quantity * book.getPrice();
			total += subTotal;
		}
		return total;
	}
	
	public void clearCart() {
		cart.clear();
	}
	
	
	public int getTotalItems() {
		return cart.size();
	}
	
 }