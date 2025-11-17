package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateConfig;
import com.dao.CMSDao;
import com.dao.CMSDaoIMPL;
import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;

public class CMSServiceImpl implements CMSService {

	SessionFactory sf = HibernateConfig.getConnection();
	CMSDao dao = new CMSDaoIMPL();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCourse() {
		System.out.print("Enter Course Name: ");
		String name = sc.nextLine();

		Course c = new Course();
		c.setCourseName(name);
		dao.addCourseInDao(c);

		System.out.println("Course Added Successfully!");
	}

	@Override
	public void displayCourseDetails() {
		List<Course> list = dao.displayCourseDetailsInDao();
		if (list.isEmpty()) {
			System.out.println("No Courses Found!");
		} else {
			System.out.println("----- Course Details -----");
			for (Course c : list) {
				System.out.println("Course ID: " + c.getCourseId() + " | Name: " + c.getCourseName());
			}
		}
	}

	@Override
	public void addFaculty() {
		Faculty f = new Faculty();

		System.out.print("Enter Faculty Name: ");
		f.setFacultyName(sc.nextLine());

		System.out.print("Enter Faculty Address: ");
		f.setFacultyAddress(sc.nextLine());

		System.out.print("Enter Faculty Mobile No: ");
		f.setFacultyMobileNo(sc.nextDouble());
		sc.nextLine();

		System.out.print("Enter Faculty Email ID: ");
		f.setFacultyEmailID(sc.nextLine());

		displayCourseDetails();
		System.out.print("Enter Course ID to assign Faculty: ");
		int courseId = sc.nextInt();
		sc.nextLine();

		Session session = sf.openSession();
		Course course = session.get(Course.class, courseId);
		session.close();

		if (course != null) {
			f.setCourse(course);
			dao.addFacultyInDao(f);
			System.out.println("✅ Faculty Added Successfully to Course: " + course.getCourseName());
		} else {
			System.out.println("❌ Invalid Course ID!");
		}
	}

	@Override
	public void displayFacultyDetails() {
		List<Faculty> list = dao.displayFacultyDetailsInDao();
		if (list.isEmpty()) {
			System.out.println("No Faculty Found!");
		} else {
			for (Faculty f : list) {
				System.out.println("----------------------------------------");
				System.out.println("Faculty ID: " + f.getFacultyId());
				System.out.println("Name: " + f.getFacultyName());
				System.out.println("Address: " + f.getFacultyAddress());
				System.out.println("Mobile: " + f.getFacultyMobileNo());
				System.out.println("Email: " + f.getFacultyEmailID());
				if (f.getCourse() != null)
					System.out.println("Course: " + f.getCourse().getCourseName());
			}
		}
	}

	@Override
	public void addBatch() {
		System.out.print("Enter Batch Name: ");
		String batchName = sc.nextLine();

		System.out.print("Enter Batch Time: ");
		String batchTime = sc.nextLine();

		System.out.print("Enter Faculty ID to assign: ");
		int facultyId = sc.nextInt();
		sc.nextLine();

		Session session = sf.openSession();
		Faculty f = session.get(Faculty.class, facultyId);
		session.close();

		if (f != null) {
			Batch b = new Batch();
			b.setBatchName(batchName);
			b.setBatchTime(batchTime);
			b.setFaculty(f);

			Session s = sf.openSession();
			s.beginTransaction();
			s.save(b);
			s.getTransaction().commit();
			s.close();

			System.out.println("✅ Batch Added Successfully and Assigned to Faculty: " + f.getFacultyName());
		} else {
			System.out.println("❌ Invalid Faculty ID!");
		}
	}

	@Override
	public void displayBatchDetails() {
		dao.displayBatchDetailsInDao();
	}

	@Override
	public void addStudent() {
		Student s = new Student();

		System.out.print("Enter Student Name: ");
		s.setStudentName(sc.nextLine());

		System.out.print("Enter Student Address: ");
		s.setStudentAddress(sc.nextLine());

		System.out.print("Enter Student Mobile No: ");
		s.setStudentMobileNo(sc.nextDouble());
		sc.nextLine();

		System.out.print("Enter Student Email ID: ");
		s.setStudentEmailId(sc.nextLine());

		System.out.print("Enter Batch ID to assign: ");
		int batchId = sc.nextInt();
		sc.nextLine();

		Session session = sf.openSession();
		Batch b = session.get(Batch.class, batchId);
		session.close();

		if (b != null) {
			s.setBatch(b);

			Session s1 = sf.openSession();
			s1.beginTransaction();
			s1.save(s);
			s1.getTransaction().commit();
			s1.close();

			System.out.println("✅ Student Added Successfully in Batch: " + b.getBatchName());
		} else {
			System.out.println("❌ Invalid Batch ID!");
		}
	}

	@Override
	public void displayStudentDetails() {
		dao.displayStudentDetailsInDao();
	}
}
