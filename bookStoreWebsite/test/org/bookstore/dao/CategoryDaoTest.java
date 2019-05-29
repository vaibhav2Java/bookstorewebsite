package org.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.bookstore.entity.Category;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CategoryDaoTest {
	public static CategoryDAO categoryDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoryDAO = new CategoryDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {


	}

	@Test
	public void testCreateCategory() {
		Category newCat1 = new Category("Engineering");
		Category category = categoryDAO.create(newCat1);
		assertTrue(category != null && category.getCategoryId()>0);
	}

	@Test
	public void testUpdateCategory() {
		Category cat = new Category("Hibernate");
				cat.setCategoryId(3);
				Category update = categoryDAO.update(cat);
				assertEquals(cat.getCategoryName(), update.getCategoryName());
	}

	@Test
	public void testGet() {
		
		Integer catid= 22;
		Category cat = categoryDAO.get(catid);
		assertNotNull(cat);
	}

	@Test
	public void testDeleteObject() {
		Integer catid= 22;
		categoryDAO.delete(catid);
		
		Category category = categoryDAO.get(catid);
		assertNull(category);
	}

	@Test
	public void testListAll() {
		List<Category> listCategory = categoryDAO.listAll();
		listCategory.forEach(c -> System.out.println(c.getCategoryName() +","));
		assertTrue(listCategory.size()>0);
	}

	@Test
	public void testCount() {
		
		long totalCategories = categoryDAO.count();
		assertEquals(totalCategories, 5);
	}

}
