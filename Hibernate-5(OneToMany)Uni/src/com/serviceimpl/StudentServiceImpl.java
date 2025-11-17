package com.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateConfig;
import com.model.Student;
import com.model.Subject;
import com.service.StudentService;

public class StudentServiceImpl implements StudentService {
	SessionFactory sf = HibernateConfig.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudent() {
		Session s = sf.openSession();
		System.out.println("Enter Number of student u need to Add");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			Student stud = new Student();
			System.out.println("Enter Student Name");
			stud.setsName(sc.next());
			System.out.println("Enter Number of subject u need to add");
			int sCount = sc.nextInt();
			
			List<Subject> subList = new ArrayList<Subject>();
			for (int j = 1; j <= sCount; j++) {
				Subject sub = new Subject();
				System.out.println("Enter Subject Name");
				sub.setSubName(sc.next());
				subList.add(sub);

			}
			stud.setSubject(subList);
			s.save(stud);
		}
		s.beginTransaction().commit();
		System.out.println("Student Added Successfully");

	}

	@Override
	public void getStudentOnlyUsingsid() {
		Session s = sf.openSession();
		System.out.println("Enter Student Id u need to Display the Details");
		int id = sc.nextInt();
		Student stud = s.get(Student.class, id);
		if (stud != null) {
			System.out.println("Student Name" + stud.getsName());
//			System.out.println("Student Subjects : "+stud.getSubject());
		} else {
			System.out.println("Invalid Student ID");
		}

	}

	@Override
	public void getSubjectOnlyUsingsid() {
		Session s = sf.openSession();
		System.out.println("Enter Student Id u need to Display the Details");
		int id = sc.nextInt();
		Student stud = s.get(Student.class, id);
		if (stud != null) {
			List<Subject> subList = stud.getSubject();
			System.out.println("Subjects of Student whose id is " + id + " :");
			for (Subject subject : subList) {
				System.out.println(subject);
			}
		} else {
			System.out.println("Invalid Student ID");
		}

	}

	@Override
	public void updateStudentDetailsUsingsid() {
		Session s = sf.openSession();
		System.out.println("Enter Student Id u need to Display the Details");
		int id = sc.nextInt();
		Student stud = s.get(Student.class, id);
		if (stud != null) {
			System.out.println("Enter Name u Need to update");
			stud.setsName(sc.next());
			s.update(stud);
			s.beginTransaction().commit();
		} else {
			System.out.println("Invalid Student ID");
		}

	}

	@Override
	public void updateSubjectDetailsUsingsid() {
		Session s = sf.openSession();
		System.out.println("Enter Student Id u need to Display the Details");
		int id = sc.nextInt();
		Student stud = s.get(Student.class, id);
		if (stud != null) {
			List<Subject> subList = stud.getSubject();
			for (Subject subject : subList) {
				System.out.println("Enter Subject Id you Need to update");
				if (subject.getSubId() == sc.nextInt()) {
					System.out.println("Enter Subject Name u need to update");
					subject.setSubName(sc.next());
					s.update(stud);
					s.beginTransaction().commit();
					break;
				}
			}
		} else {
			System.out.println("Invalid Student ID");
		}

	}

	@Override
	public void deleteStudentOnlyUsingsid() {
		Session s = sf.openSession();
		System.out.println("Enter Student Id u need to Display the Details");
		int id = sc.nextInt();
		Student stud = s.get(Student.class, id);
		if (stud != null) {
			stud.setSubject(null);
			s.delete(stud);
			s.beginTransaction().commit();
		} else {
			System.out.println("Invalid Student ID");
		}

	}

	@Override
	public void deleteSubjectOnlyUsingsid() {
		Session s = sf.openSession();
		System.out.println("Enter Student Id u need to Delete the Subject");
		int id = sc.nextInt();
		Student stud = s.get(Student.class, id);
		if (stud != null) {
			List<Subject> subList = stud.getSubject();
			System.out.println("Enter Subject Id you Need to Delete");
			int subid = sc.nextInt();
			Subject sub = null;
			for (Subject subject : subList) {
				if (subject != null && subject.getSubId() == subid) {
					sub = subject;
					break;
				}
			}
			subList.remove(sub);
			stud.setSubject(subList);
			s.delete(sub);
			s.beginTransaction().commit();
		} else {
			System.out.println("Invalid Student ID");
		}

	}

}