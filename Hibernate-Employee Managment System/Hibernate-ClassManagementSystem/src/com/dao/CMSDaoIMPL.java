package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateConfig;
import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;

public class CMSDaoIMPL implements CMSDao {

	SessionFactory sf = HibernateConfig.getConnection();

	@Override
	public void addCourseInDao(Course course) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(course);
		tx.commit();
		session.close();
	}

	@Override
	public List<Course> displayCourseDetailsInDao() {
		Session session = sf.openSession();
		List<Course> list = session.createQuery("from Course", Course.class).list();
		session.close();
		return list;
	}

	@Override
	public void addFacultyInDao(Faculty faculty) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(faculty);
		tx.commit();
		session.close();
	}

	@Override
	public List<Faculty> displayFacultyDetailsInDao() {
		Session session = sf.openSession();
		List<Faculty> list = session.createQuery("from Faculty", Faculty.class).list();
		session.close();
		return list;
	}

	@Override
	public void addBatchInDao(String batchName, int facultyId) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Faculty faculty = session.get(Faculty.class, facultyId);
		if (faculty != null) {
			Batch batch = new Batch();
			batch.setBatchName(batchName);
			batch.setFaculty(faculty);

			session.save(batch);
			tx.commit();
			System.out.println("✅ Batch '" + batchName + "' assigned to Faculty: " + faculty.getFacultyName());
		} else {
			System.out.println("❌ Invalid Faculty ID!");
			tx.rollback();
		}
		session.close();
	}

	@Override
	public void displayBatchDetailsInDao() {
		Session session = sf.openSession();
		List<Batch> list = session.createQuery("from Batch", Batch.class).list();

		for (Batch b : list) {
			System.out.println("----------------------------------------");
			System.out.println("Batch ID: " + b.getBatchId());
			System.out.println("Batch Name: " + b.getBatchName());
			System.out.println("Batch Time: " + b.getBatchTime());
			if (b.getFaculty() != null) {
				System.out.println("Faculty: " + b.getFaculty().getFacultyName());
				System.out.println("Course: " + b.getFaculty().getCourse().getCourseName());
			}
		}
		session.close();
	}

	@Override
	public void addStudentInDao() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
	}

	@Override
	public void displayStudentDetailsInDao() {
		Session session = sf.openSession();
		List<Student> list = session.createQuery("from Student", Student.class).list();

		for (Student s : list) {
			System.out.println("----------------------------------------");
			System.out.println("Student ID: " + s.getStudentId());
			System.out.println("Name: " + s.getStudentName());
			System.out.println("Address: " + s.getStudentAddress());
			System.out.println("Mobile: " + s.getStudentMobileNo());
			System.out.println("Email: " + s.getStudentEmailId());
			if (s.getBatch() != null) {
				System.out.println("Batch: " + s.getBatch().getBatchName());
				if (s.getBatch().getFaculty() != null) {
					System.out.println("Faculty: " + s.getBatch().getFaculty().getFacultyName());
					System.out.println("Course: " + s.getBatch().getFaculty().getCourse().getCourseName());
				}
			}
		}
		session.close();
	}
}
