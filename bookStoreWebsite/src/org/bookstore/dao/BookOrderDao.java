package org.bookstore.dao;

import java.util.Date;
import java.util.List;

import org.bookstore.entity.BookOrder;

public class BookOrderDao extends JpaDAO<BookOrder> implements GenericDAO<BookOrder> {

	@Override
	public BookOrder create(BookOrder order) {
		order.setOrderDate(new Date());
		order.setPaymentMethod("Cash on delivery");
		order.setStatus("Processing");
		return super.create(order);
	}

	@Override
	public BookOrder update(BookOrder order) {
		return super.update(order);
	}

	@Override
	public BookOrder get(Object orderid) {
		return super.find(BookOrder.class, orderid);
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
