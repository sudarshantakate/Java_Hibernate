package com.controller;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class TestController {

	public static void main(String[] args) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();

		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		System.out.println("Enter Employee ID: ");
		employee.setEmpId(sc.nextInt());
		System.out.println("Enter Employee Name: ");
		employee.setEmpName(sc.next());
		System.out.println("Enetr Employee Salarry:");
		employee.setSalarry(sc.nextDouble());

		session.save(employee);

		session.beginTransaction().commit();
		System.out.println("Employee Data Saved!!");

	}
}
