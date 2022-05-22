package com.bkap.dao;

import java.util.List;
import com.bkap.entities.Category;

public class CategoryDAO implements IBusinessDAO<Category, Integer> {

	@Override
	public List<Category> getAll() {
		return null;
	}

	@Override
	public Category getById(Integer id) {
		return null;
	}

	@Override
	public List<Category> search(String name) {
		return null;
	}

	@Override
	public boolean insert(Category e) {
		return false;
	}

	@Override
	public boolean update(Category e) {
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

}
