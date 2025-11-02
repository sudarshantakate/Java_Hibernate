package com.serviceimpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateConfig;
import com.model.Aadhar;
import com.model.Person;
import com.service.PersionService;

public class PersionServiceImpl implements PersionService {

	SessionFactory sf = HibernateConfig.getSessionfacFactory();

	@Override
	public void addPersionWithAadhar() {

		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		Person p = new Person();
		System.out.println("Enter Person Name: ");
		p.setPname(sc.next());
		System.out.println("Enter Person Address: ");
		p.setPaddress(sc.next());

		Aadhar aadhar = new Aadhar();
		System.out.println("Enter Aadhar Number: ");
		aadhar.setAadharNumber(sc.nextInt());

		p.setAadhar(aadhar);

		session.save(p);
		session.beginTransaction().commit();
		session.close();
		System.out.println("Person Saved!!");

	}

	@Override
	public void getPersionOnlyUsingPid() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person ID:: ");
		int id = sc.nextInt();
		Person p = session.get(Person.class, id);
		if (p != null) {

			System.out.println(p);
			session.beginTransaction().commit();
			session.close();
		} else {
			System.out.println("Invalid ID!!");
		}

	}

	@Override
	public void getAadharOnlyUsingPid() {
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person ID:: ");
		int id = sc.nextInt();
		Person p = session.get(Person.class, id);
		if (p != null) {

			Aadhar aadhar = p.getAadhar();
			System.out.println(aadhar);
			session.beginTransaction().commit();
			session.close();
		} else {
			System.out.println("ID Invalid!!");
		}

	}

	@Override
	public void updatePersionDetailsUsingPid() {
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person ID:: ");
		int id = sc.nextInt();
		Person p = session.get(Person.class, id);
		if (p != null) {

			System.out.println("Enter Person Name who want to update:: ");
			String pname = sc.next();
			p.setPname(pname);

			session.beginTransaction().commit();
			session.close();
			System.out.println("Person update Successfully!!");
		} else {
			System.out.println("ID Invalid!!");
		}

	}

	@Override
	public void updateAadharDetailsUsingPid() {
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person ID:: ");
		int id = sc.nextInt();
		Person p = session.get(Person.class, id);
		if (p != null) {

			Aadhar aadhar = p.getAadhar();
			System.out.println("Enter Aadhar Number you want to update:: ");
			int aadharNumber = sc.nextInt();
			aadhar.setAadharNumber(aadharNumber);

			session.beginTransaction().commit();
			session.close();
			System.out.println("Aadhar update Successfully!!");
		} else {
			System.out.println("ID Invalid!!");
		}

	}

	@Override
	public void deletePersionDetailsUsingPid() {
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person ID:: ");
		int id = sc.nextInt();
		Person p = session.get(Person.class, id);
		if (p != null) {
			p.setAadhar(null);

			session.delete(p);

			session.beginTransaction().commit();
			session.close();
		} else {
			System.out.println("ID Invalid!!");
		}

	}

	@Override
	public void deleteAadharDetailsUsingPid() {
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Person ID:: ");
		int id = sc.nextInt();
		Person p = session.get(Person.class, id);
		if (p != null) {
			Aadhar aadhar = p.getAadhar();
			if (aadhar != null) {
				p.setAadhar(null);
				session.delete(aadhar);
				System.out.println("Aadhar details deleted successfully!");
			} else {
				System.out.println("No Aadhar linked with this person.");
			}

			session.beginTransaction().commit();
			session.close();
		} else {
			System.out.println("ID Invalid!!");
		}

	}

}
