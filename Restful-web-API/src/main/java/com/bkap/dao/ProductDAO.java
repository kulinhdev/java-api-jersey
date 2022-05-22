package com.bkap.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.bkap.entities.Product;
import com.bkap.utils.HibernateUtil;

@SuppressWarnings("unchecked")
public class ProductDAO implements IBusinessDAO<Product, Integer> {
	Session session;

	@Override
	public List<Product> getAll() {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			Query query = session.createQuery("from Product");
			List<Product> products = query.getResultList();

			return products;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public Product getById(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			Product product = session.get(Product.class, id);

			return product;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Product> search(String name) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			Query q = session.createQuery("from Product p where p.name like :name");
			q.setParameter("name", "%" + name + "%");
			List<Product> result = q.getResultList();
			return result;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean insert(Product p) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
			session.close();

			return true;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());

			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean update(Product p) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
			session.close();

			return true;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());

			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean delete(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			Product p = session.get(Product.class, id);
			session.delete(p);
			session.getTransaction().commit();

			return true;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());

			return false;
		} finally {
			session.close();
		}
	}
}
