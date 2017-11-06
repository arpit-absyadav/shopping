package com.abs.shoppingbackend.dao;

import java.util.List;

import com.abs.shopingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	
	Category get(int id);
	
	
	
	boolean add(Category category);
}
