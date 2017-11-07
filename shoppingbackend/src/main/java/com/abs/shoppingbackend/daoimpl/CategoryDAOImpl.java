package com.abs.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abs.shoppingbackend.dao.CategoryDAO;
import com.abs.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	// for static data
	// private static List<Category> categories = new ArrayList<>();
	//
	// static {
	// Category category = new Category();
	//
	// // adding first category
	// category.setId(1);
	// category.setName("Television");
	// category.setDescription("This is desription for television");
	// category.setImageURL("Cat_img01.png");
	//
	// categories.add(category);
	//
	// // adding second category
	// category = new Category();
	// category.setId(2);
	// category.setName("Mobile");
	// category.setDescription("This is desription for mobile");
	// category.setImageURL("Cat_img02.png");
	//
	// categories.add(category);
	//
	// // adding third category
	// category = new Category();
	// category.setId(3);
	// category.setName("Laptop");
	// category.setDescription("This is desription for laptop");
	// category.setImageURL("Cat_img03.png");
	//
	// categories.add(category);
	// }

	@Override
	public List<Category> list() {
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	/*
	 * Getting single category using id
	 * 
	 */
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
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

	@Override
	public boolean update(Category category) {
		try {
			// updating the category to database
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		try {
			// deleting the category to database
			// not deleting exactly. instead of that setting that is_active as
			// false

			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
