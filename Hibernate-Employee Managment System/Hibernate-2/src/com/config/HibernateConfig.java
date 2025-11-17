package com.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.model.User;

public class HibernateConfig {


	private HibernateConfig() {

	}

	private static SessionFactory sf = null;

	private static StandardServiceRegistry registry = null;

	public static SessionFactory getSessionfacFactory() {

		if (sf == null) {

			// Connection Properties
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/college");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");

			// Hibernate Properties
			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
			map.put(Environment.HBM2DDL_AUTO, "update");
			map.put(Environment.SHOW_SQL, true);

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();// encapsulate the all
																						// configuration of connection

			// create one session factory using registry
			MetadataSources metadataSources = new MetadataSources(registry).addAnnotatedClass(User.class);// store data of all properties data

			Metadata md = metadataSources.getMetadataBuilder().build();

			sf = md.getSessionFactoryBuilder().build();
			
		}
		return sf;
	}
}
