package com.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.config.HibernateConfig;
import com.entity.Employee;
import com.mysql.jdbc.exceptions.jdbc4.MySQLQueryInterruptedException;

public class Main {
	public static void main(String[] args) {

		SessionFactory sf = HibernateConfig.getSessionfacFactory();
//
//		Session session = sf.openSession();
//		
//		Employee emp = new Employee();
//		
//		emp.setEname("Sudarshan");
//		emp.setEaddress("Pune");
//		emp.seteSalary(7000000);
//		
//		
//		session.save(emp);
//		
//		System.out.println("Employee data updated!!");
//		session.beginTransaction().commit();
//		session.close();

		// fetch data from db using criteria api

		Session session = sf.openSession();

		CriteriaBuilder build = session.getCriteriaBuilder();

		//select * from employee write this query in the follwing form
		CriteriaQuery<Employee> query = build.createQuery(Employee.class);//build query 
		
		Root<Employee> root = query.from(Employee.class);//from employee part is here which is called root 
		query.select(root);

		Query<Employee> queries = session.createQuery(query);
		
		List<Employee> list = queries.getResultList();//fetch list of data from here 
		
		System.out.println(list);

	}

}
