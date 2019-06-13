package org.bookstore.entity;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class BookRatingTest {


	@Test
	public void testBookAverageRating() {
		Book book = new Book();
		Set<Review> reviews = new HashSet<>();
		Review review1 = new Review();
		review1.setRating(5);
		reviews.add(review1);
		book.setReviews(reviews);
		
		float averageRating = book.getAverageRating();
		assertEquals(5.0, averageRating,0.0);
		
	}
	
	
	@Test
	public void testBookAverageString() {
		
		float averageRating = 0.0f;
		Book book = new Book();
		String actual = book.getRatingString(averageRating);
		String expected = "off,off,off,off,off";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testBookAverageString1() {
		
		float averageRating = 3.0f;
		Book book = new Book();
		String actual = book.getRatingString(averageRating);
		String expected = "on,on,on,off,off";
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testBookAverageString2() {
		
		float averageRating = 2.6f;
		Book book = new Book();
		String actual = book.getRatingString(averageRating);
		String expected = "on,on,half,off,off";
		assertEquals(expected, actual);
	}
}
