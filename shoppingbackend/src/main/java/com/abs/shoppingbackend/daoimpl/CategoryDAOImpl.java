package com.abs.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes.Name;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abs.shopingbackend.dto.Category;
import com.abs.shoppingbackend.dao.CategoryDAO;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is desription for television");
		category.setImageURL("Cat_img01.png");

		categories.add(category);

		// adding second category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is desription for mobile");
		category.setImageURL("Cat_img02.png");

		categories.add(category);

		// adding third category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is desription for laptop");
		category.setImageURL("Cat_img03.png");

		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		System.out.println(categories);
		return categories;
	}

	@Override
	public Category get(int id) {
		for (Category category : categories)
			if (category.getId() == id) {
				return category;
			}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			// adding the category to database
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
