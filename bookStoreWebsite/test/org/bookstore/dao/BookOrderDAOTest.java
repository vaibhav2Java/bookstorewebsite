package org.bookstore.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.bookstore.entity.Book;
import org.bookstore.entity.BookOrder;
import org.bookstore.entity.Customer;
import org.bookstore.entity.OrderDetail;
import org.bookstore.entity.OrderDetailId;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BookOrderDAOTest {
	
	static BookOrderDao orderDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		orderDao = new BookOrderDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		orderDao.close();
	}

	@Test
	public void testCreateBookOrder() {
	 BookOrder order = new BookOrder();
	 Customer customer = new Customer();
	 customer.setCustomerId(24);
	 order.setCustomer(customer);
	 order.setRecipientFirstName("vaibhav");
	 order.setRecipientLastName("bhatnagar");
	 order.setRecipientPhone("7617088947");
	 order.setShippingAddress("A-114 new Ashok Nagar!");
	 
	 
	 Set<OrderDetail> orderDetails = new HashSet<>();
	 OrderDetail orderDetail = new OrderDetail();
	 
	 
	 Book book = new Book(1);
	 orderDetail.setBook(book);
	 orderDetail.setQuantity(2);
	 orderDetail.setSubtotal(77.74f);
	 orderDetail.setBookOrder(order);
	 
	 
	 orderDetails.add(orderDetail);
	 order.setOrderDetails(orderDetails);
	 BookOrder create = orderDao.create(order);
	 assertNotNull(create.getOrderId()>0);
	}
	
	@Test
	public void testCreateBookOrder2() {
	 BookOrder order = new BookOrder();
	 Customer customer = new Customer();
	 customer.setCustomerId(14);
	 order.setCustomer(customer);
	 order.setRecipientFirstName("kamal");
	 order.setRecipientLastName("Kumar");
	 order.setRecipientPhone("7379101001");
	 order.setShippingAddress("Kanpur");
	 
	 
	 Set<OrderDetail> orderDetails = new HashSet<>();
	 OrderDetail orderDetail1 = new OrderDetail();
	 
	 
	 Book book = new Book(1);
	 orderDetail1.setBook(book);
	 orderDetail1.setQuantity(2);
	 orderDetail1.setSubtotal(77.74f);
	 orderDetail1.setBookOrder(order);
	 
	 orderDetails.add(orderDetail1);
	 
	 Book book2 = new Book(1);
	 OrderDetail orderDetail2 = new OrderDetail();
	 orderDetail2.setBook(book2);
	 orderDetail2.setQuantity(4);
	 orderDetail2.setSubtotal(36.72f);
	 orderDetail2.setBookOrder(order);
	 
	 orderDetails.add(orderDetail2);

	 
	 
	 
	 order.setOrderDetails(orderDetails);
	 BookOrder myorder = orderDao.create(order);
	 assertNotNull(myorder.getOrderId()>0);
	}


	@Test
	public void testUpdateBookOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		Integer orderId = 7;
		BookOrder bookOrder = orderDao.get(orderId);
		assertEquals(1, bookOrder.getOrderDetails().size());
	}

	@Test
	public void testDeleteObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

}
