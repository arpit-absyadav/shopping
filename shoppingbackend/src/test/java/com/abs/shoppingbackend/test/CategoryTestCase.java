package com.abs.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abs.shopingbackend.dto.Category;
import com.abs.shoppingbackend.dao.CategoryDAO;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.abs.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	
	/*
	 * 
	 * 
	 * NOTE: If the ERROR : Cannot create PoolableConnectionFactory then check
	 * the database version and your database jar version (shoud be same).
	 * 
	 */

	@Test
	public void testAddCategory() {
		category = new Category();

		category.setName("Television");
		category.setDescription("This is desription for television");
		category.setImageURL("Cat_img01.png");

		assertEquals("Successfully added the category inside the table!", true, categoryDAO.add(category));
	}
}
