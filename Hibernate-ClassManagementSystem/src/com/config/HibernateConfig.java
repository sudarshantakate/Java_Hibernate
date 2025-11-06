package com.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;

public class HibernateConfig {

	private HibernateConfig() {

	}

	private static SessionFactory sf = null;
	public static StandardServiceRegistry registry = null;

	public static SessionFactory getConnection() {

		if (sf == null) {
			// Connection Properties
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/ClassMS");
			map.put(Environment.USER, "project");
			map.put(Environment.PASS, "project123");

			// Hibernate Properties
			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
			map.put(Environment.HBM2DDL_AUTO, "create");
			map.put(Environment.SHOW_SQL, true);

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();// encapsulate the all
																						// configuration of connection

			// create one session factory using registry
			MetadataSources metadataSources = new MetadataSources(registry).addAnnotatedClass(Course.class)
					.addAnnotatedClass(Faculty.class).addAnnotatedClass(Batch.class).addAnnotatedClass(Student.class);// store
																														// data
																														// of
																														// all
																														// propertiessdata

			Metadata md = metadataSources.getMetadataBuilder().build();

			sf = md.getSessionFactoryBuilder().build();
		}
		return sf;
	}
}
