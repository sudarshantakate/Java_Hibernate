package com.controller;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.config.HibernateConfig;
import com.model.User;

public class TestController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SessionFactory sf = HibernateConfig.getSessionfacFactory();
		Session s = sf.openSession();

		User user = new User();
		System.out.println("Enter User ID: ");
		user.setUid(sc.nextInt());

		System.out.println("Enter User Name ");
		user.setUname(sc.next());

		System.out.println("Enter User Mobile Number: ");
		user.setMobilenumber(sc.nextLong());

		s.save(user);
		s.beginTransaction().commit();
		System.out.println("User Data Saved!!");
	}
}
