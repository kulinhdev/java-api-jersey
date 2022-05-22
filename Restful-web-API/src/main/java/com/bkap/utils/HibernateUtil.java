package com.bkap.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		if (sessionFactory == null) {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources sources = new MetadataSources(registry);
			Metadata metadata = sources.getMetadataBuilder().build();
			
			// Update sessionFactory
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
