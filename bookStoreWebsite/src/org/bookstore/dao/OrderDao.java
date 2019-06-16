package org.bookstore.dao;

import java.util.List;

import org.bookstore.entity.BookOrder;

public class OrderDao extends JpaDAO<BookOrder> implements GenericDAO<BookOrder> {

	@Override
	public BookOrder create(BookOrder order) {
		return super.create(order);
	}

	@Override
	public BookOrder update(BookOrder order) {
		return super.update(order);
	}

	@Override
	public BookOrder get(Object id) {
		return super.find(BookOrder.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(BookOrder.class, id);
	}

	@Override
	public List<BookOrder> listAll() {
		return super.findwithNamedQuery("BookOrder.findAll");
	}

	@Override
	public long count() {
		return super.countwithNamedQuery("BookOreder.countAll");
	}

}
