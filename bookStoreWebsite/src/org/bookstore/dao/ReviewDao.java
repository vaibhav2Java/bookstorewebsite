package org.bookstore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bookstore.entity.Review;

public class ReviewDao extends JpaDAO<Review> implements GenericDAO<Review> {

	@Override
	public Review create(Review review) {
		review.setReviewTime(new Date());
		return super.create(review);
	}

	@Override
	public Review get(Object id) {
		return super.find(Review.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Review.class, id);
	}

	@Override
	public List<Review> listAll() {
		return super.findwithNamedQuery("Review.findAll");
	}

	@Override
	public long count() {
		return super.countwithNamedQuery("Review.countAll");
	}

	@Override
	public Review update(Review review) {
		return super.update(review);
	}
	
	
	public Review findbyCustomerAndBook(Integer customerId, Integer bookId){
		Map <String,Object> parameters = new HashMap<>();
		parameters.put("customerId", customerId);
		parameters.put("bookId", bookId);
		List<Review> result = super.findwithNamedQuery("Review.findbyCustomerAndBook",parameters);
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

}
