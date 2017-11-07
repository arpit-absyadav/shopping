package com.abs.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abs.shoppingbackend.dao.CategoryDAO;
import com.abs.shoppingbackend.dto.Category;

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

	/*
	 * @Test public void testAddCategory() { category = new Category();
	 * 
	 * category.setName("Laptop");
	 * category.setDescription("This is desription for laptop");
	 * category.setImageURL("Cat_img03.png");
	 * 
	 * assertEquals("Successfully added the category inside the table!", true,
	 * categoryDAO.add(category)); }
	 */

	/*
	 * Test get category
	 */

	/*
	 * @Test public void testGetcategory(){ category = categoryDAO.get(3);
	 * assertEquals("Successfully fetched the category from the table!",
	 * "Laptop", category.getName()); }
	 */

	/*
	 * @Test public void testUpdatecategory(){ category = categoryDAO.get(1);
	 * category.setName("TV");
	 * assertEquals("Successfully updated the category in the table!", true,
	 * categoryDAO.update(category)); }
	 * 
	 */

	/*
	 * @Test public void testdeletecategory(){ category = categoryDAO.get(1);
	 * assertEquals("Successfully deleted the category in the table!", true,
	 * categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListcategory(){
	 * assertEquals("Successfully fetched the List of category frrom the table!"
	 * , 2, categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {

		// add test operation
		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is desription for laptop");
		category.setImageURL("Cat_img01.png");

		assertEquals("Successfully added the category inside the table!", true, categoryDAO.add(category));

		category = new Category();
		category.setName("Television");
		category.setDescription("This is desription for television");
		category.setImageURL("Cat_img02.png");

		assertEquals("Successfully added the category inside the table!", true, categoryDAO.add(category));

		// Fetching and updating
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated the category in the table!", true, categoryDAO.update(category));

		// Delting the category

		assertEquals("Successfully deleted the category in the table!", true, categoryDAO.delete(category));

		// Fetching the categories
		assertEquals("Successfully fetched the List of category frrom the table!", 1, categoryDAO.list().size());

	}

}
