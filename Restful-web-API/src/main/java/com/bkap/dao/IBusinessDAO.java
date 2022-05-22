package com.bkap.dao;

import java.util.List;

public interface IBusinessDAO<T, K> {
	public List<T> getAll();
	public T getById(K id);
	public List<T> search(String name);
	public boolean insert(T p);
	public boolean update(T p);
	public boolean delete(K id);
}
