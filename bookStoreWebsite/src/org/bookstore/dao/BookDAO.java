package org.bookstore.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.bookstore.entity.Book;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {

	public BookDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Book get(Object bookId) {
		return super.find(Book.class, bookId);
	}

	@Override
	public void delete(Object bookId) {
		super.delete(Book.class, bookId);
	}

	@Override
	public List<Book> listAll() {
		return super.findwithNamedQuery("Book.findAll");
	}
	
	public Book findByTitle(String title) {
		List<Book> findwithNamedQuery = super.findwithNamedQuery("Book.findByTitle", "title",title);
		if (!findwithNamedQuery.isEmpty()) {
			return findwithNamedQuery.get(0);
		}
		return null;
	}
	
	public List<Book> listByCategory(int categoryId){
		return super.findwithNamedQuery("Book.byCategory","catId", categoryId);
	}
	

	@Override
	public long count() {
		 return super.countwithNamedQuery("Book.countAll");
	}

	@Override
	public Book create(Book book) {
		book.setLastUpdateTime(new Date());
		return super.create(book);
	}

	@Override
	public Book update(Book book) {
		book.setLastUpdateTime(new Date());
		return super.update(book);
	}
	
	public List<Book> searchBook(String keyword) {
		return super.findwithNamedQuery("Book.search", "keyword", keyword);
	}
	
	

}
