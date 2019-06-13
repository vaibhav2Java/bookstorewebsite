package org.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bookstore.dao.ReviewDao;
import org.bookstore.entity.Review;

public class ReviewService {
	
	private ReviewDao reviewDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	
	public ReviewService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.reviewDao = new ReviewDao();
	}

	public void listAllReviews() throws ServletException, IOException {
		listAllReviews(null);
	}

	public void listAllReviews(String message) throws ServletException, IOException {
		if (message != null) {
			request.setAttribute("message", message);
		}
		List<Review> reviewAll = reviewDao.listAll();
		System.out.println("Book title" +reviewAll.get(0).getBook().getTitle());
		request.setAttribute("listAllreview", reviewAll);
		String listReviewPage="list_reviews.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listReviewPage);
		dispatcher.forward(request, response);
	}

	public void deleteReview() throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id:" +id);
		reviewDao.delete(id);
		String message= "Review Deleted Successfully";
		request.setAttribute("message", message);
		listAllReviews(message);
		
	}

	public void editReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		Review editReview = reviewDao.get(reviewId);
		request.setAttribute("editReview", editReview);
		String editPage="form_review.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	public void updateReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		Review review = reviewDao.get(reviewId);
		review.setHeadline(headline);
		review.setComment(comment);
		reviewDao.update(review);
		String message= "Review is updated Successfully";
		request.setAttribute("message", message);
		listAllReviews(message);
	}

	public void showReviewForm() throws ServletException, IOException {
		String reviewFrom = "frontend/reviewForm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(reviewFrom);
		dispatcher.forward(request, response);
	}
}
