package com.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.entity.User;

public class HibernateConfig {

	private HibernateConfig() {
	}

	private static SessionFactory sf = null;

	private static StandardServiceRegistry registry = null;

	public static SessionFactory getSessionFactory() {

		if (sf == null) {

			Map<String, Object> map = new HashMap<String, Object>();

			// Connection Property
			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/college");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");

			// Hibernate property
			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
			map.put(Environment.HBM2DDL_AUTO, "create");
			map.put(Environment.SHOW_SQL, true);

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();

			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(User.class);

			Metadata md = mds.getMetadataBuilder().build();

			sf= md.getSessionFactoryBuilder().build();
		}
		return sf;
	}
}
