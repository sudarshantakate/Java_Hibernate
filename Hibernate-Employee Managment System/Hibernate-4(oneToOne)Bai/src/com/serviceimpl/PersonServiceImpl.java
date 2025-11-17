package com.serviceimpl;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.*;
import com.model.*;
import com.service.PersonService;

public class PersonServiceImpl implements PersonService {
	SessionFactory sf = HibernateConfig.getSessionfacFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addperson() {
		Session s = sf.openSession();
		System.out.println("Enter number of person u need to add :");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			Person p = new Person();
			System.out.println("Enter Person Name :");
			p.setpName(sc.next());
			System.out.println("Enter Address :");
			p.setpAddress(sc.next());

			Adhar adhar = new Adhar();
			System.out.println("Enter Adhar Number :");
			adhar.setAdharNo(sc.nextLong());
			p.setAdhar(adhar);
			adhar.setPerson(p);
			s.save(p);
			s.beginTransaction().commit();
			System.out.println("Person Details Saved");
			if (i < n) {
				System.out.println("Enter Next Person Details...!\n");
			}

		}

	}

	@Override
	public void getPersonOnlyUsingPid() {
		Session s = sf.openSession();
		System.out.println("Enter pId u need to See Details :");
		int id = sc.nextInt();
		Person person = s.get(Person.class, id);
		if (person != null) {
			System.out.println("Person ID : " + person.getPid());
			System.out.println("Person Name : " + person.getpName());
		} else {
			System.out.println("Invalid pId");
		}

	}

	@Override
	public void getAdharOnlyUsingPid() {
		Session s = sf.openSession();
		System.out.println("Enter pId u need to See Details :");
		int id = sc.nextInt();
		Person person = s.get(Person.class, id);
		if (person != null) {
			System.out.println("Adhar ID : " + person.getAdhar().getaId());
			System.out.println("Adhar  Name : " + person.getAdhar().getAdharNo());
		} else {
			System.out.println("Invalid pId");
		}

	}

	@Override
	public void updatePersonDetailsUsingPid() {
		Session s = sf.openSession();
		System.out.println("Enter pId u need to update Details :");
		int id = sc.nextInt();
		Person person = s.get(Person.class, id);
		if (person != null) {
			System.out.println("Enter Person Name you Need to Update :");
			person.setpName(sc.next());
			s.update(person);
			s.beginTransaction().commit();
		} else {
			System.out.println("Invalid pId");
		}

	}

	@Override
	public void updateAdharDetailsUsingPid() {
		Session s = sf.openSession();
		System.out.println("Enter pId u need to update Details :");
		int id = sc.nextInt();
		Person person = s.get(Person.class, id);
		if (person != null && person.getPid() == id) {
			Adhar adhar = person.getAdhar();
			System.out.println("Enter Person Adhar Number you Need to Update :");
			adhar.setAdharNo(sc.nextLong());
			s.update(person);
			s.beginTransaction().commit();
		} else {
			System.out.println("Invalid pId");
		}

	}

	@Override
	public void deletePersonOnlyUsingPid() {
		Session s = sf.openSession();
		System.out.println("Enter pId u need to delete Details :");
		int id = sc.nextInt();
		Person person = s.get(Person.class, id);
		if (person != null) {
			Adhar adhar = person.getAdhar();
			adhar.setPerson(null);
			person.setAdhar(null);
			s.delete(person);
			s.beginTransaction().commit();
			System.out.println("Person Deleted Successfully..!");
		} else {
			System.out.println("Invalid pId");
		}

	}

	@Override
	public void deleteAdharOnlyUsingPid() {
		Session s = sf.openSession();
		System.out.println("Enter pId u need to delete Details :");
		int id = sc.nextInt();
		Person person = s.get(Person.class, id);
		Adhar adhar = person.getAdhar();
		if (person != null && person.getPid() == id) {
			person.setAdhar(null);
			adhar.setPerson(null);
			s.delete(adhar);
			s.beginTransaction().commit();
			System.out.println("Person Deleted Successfully..!");
		} else {
			System.out.println("Invalid pId");
		}

	}

	@Override
	public void getPersonOnlyUsingAid() {
		Session s = sf.openSession();
		System.out.println("Enter Adhar Id u need to See Details :");
		int id = sc.nextInt();
		Adhar adhar = s.get(Adhar.class, id);
		if (adhar != null) {
			System.out.println("Person ID : " + adhar.getPerson().getPid());
			System.out.println("Person Name : " + adhar.getPerson().getpName());
		} else {
			System.out.println("Invalid pId");
		}

	}

	@Override
	public void getAdharOnlyUsingAid() {
		Session s = sf.openSession();
		System.out.println("Enter Adhar Id u need to See Details :");
		int id = sc.nextInt();
		Adhar adhar = s.get(Adhar.class, id);
		if (adhar != null) {
			System.out.println("Adhar ID : " + adhar.getaId());
			System.out.println("Adhar Number : " + adhar.getAdharNo());
		} else {
			System.out.println("Invalid pId");
		}

	}

	@Override
	public void updatePersonDetailsUsingAid() {
		Session s = sf.openSession();
		System.out.println("Enter pId u need to update Details :");
		int id = sc.nextInt();
		Adhar adhar = s.get(Adhar.class, id);
		if (adhar != null) {
			System.out.println("Enter Person Name you Need to Update :");
			Person person = adhar.getPerson();
			person.setpName(sc.next());
			s.update(adhar);
			s.beginTransaction().commit();
		} else {
			System.out.println("Invalid pId");
		}

	}

	@Override
	public void updateAdharDetailsUsingAid() {
		Session s = sf.openSession();
		System.out.println("Enter pId u need to update Details :");
		int id = sc.nextInt();
		Adhar adhar = s.get(Adhar.class, id);
		if (adhar != null) {
			System.out.println("Enter Adhar No you Need to Update :");
			adhar.setAdharNo(sc.nextLong());
			s.update(adhar);
			s.beginTransaction().commit();
		} else {
			System.out.println("Invalid pId");
		}

	}

	@Override
	public void deletePersonOnlyUsingAid() {
		Session s = sf.openSession();
		System.out.println("Enter pId u need to delete Details :");
		int id = sc.nextInt();
		Adhar adhar = s.get(Adhar.class, id);
		if (adhar != null) {

			Person person = adhar.getPerson();
			System.out.println(person);
			person.setAdhar(null);
			adhar.setPerson(null);

			s.delete(person);
			s.beginTransaction().commit();
			System.out.println("Person Deleted Successfully..!");
		} else {
			System.out.println("Invalid pId");
		}

	}

	@Override
	public void deleteAdharOnlyUsingAid() {
		Session s = sf.openSession();
		System.out.println("Enter pId u need to delete Details :");
		int id = sc.nextInt();
		Adhar adhar = s.get(Adhar.class, id);
		if (adhar != null) {
			Person person = adhar.getPerson();
			System.out.println(person);
			person.setAdhar(null);
			adhar.setPerson(null);
			s.delete(adhar);
			s.beginTransaction().commit();
			System.out.println("Person Deleted Successfully..!");
		} else {
			System.out.println("Invalid pId");
		}


	}

}