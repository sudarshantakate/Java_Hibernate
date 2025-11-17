package com.serviceimpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateConfig;
import com.model.Company;
import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	SessionFactory sf = HibernateConfig.getSessionfacFactory();

	@Override
	public void addEmployeeWithCompany() {

		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee();
		System.out.println("Enter Employee Name: ");
		emp.setEmpName(sc.next());
		System.out.println("Enter Employee Age:");
		emp.setEmpAge(sc.nextInt());
		System.out.println("Enter Employee Salary: ");
		emp.setEmpSalary(sc.nextDouble());
		System.out.println("Enter Employee Role: ");
		emp.setEmpRole(sc.next());

		Company cmp = new Company();
		System.out.println("Enter Company Name: ");
		cmp.setCmpName(sc.next());
		System.out.println("Enter Company Address: ");
		cmp.setCmpAddress(sc.next());
		System.out.println("Enter Company Type: ");
		cmp.setCmpType(sc.next());
		System.out.println();
		System.out.println("Enter Company PinCode: ");
		cmp.setCmpPinCode(sc.nextInt());

		System.out.println("Employee Data saved!!");

		emp.setCompany(cmp);

		session.save(emp);
		session.beginTransaction().commit();
		session.close();
		System.out.println("Employee Data saved!!");
	}

	@Override
	public void getEmployeeUsingempId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee ID: ");
		int id = sc.nextInt();

		Employee emp = session.get(Employee.class, id);

		if (emp != null) {
			System.out.println(emp);

		} else {
			System.out.println("Invalid ID!!");
		}
		session.beginTransaction().commit();
		session.close();
	}

	@Override
	public void getCompanyUsingempId() {
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee ID: ");
		int id = sc.nextInt();

		Employee emp = session.get(Employee.class, id);

		if (emp != null && emp.getCompany() != null) {
			System.out.println("Company Details:\n" + emp.getCompany());
		} else {
			System.out.println("No company found for this Employee ID!");
		}
		session.beginTransaction().commit();
		session.close();

	}

	@Override
	public void updateEmployeeDetailsUsingempId() {

		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee ID: ");
		int id = sc.nextInt();

		Employee emp = session.get(Employee.class, id);

		if (emp != null) {
			System.out.println("Enter Employee Name:");
			emp.setEmpName(sc.next());

			session.update(emp);
			session.beginTransaction().commit();
			System.out.println("Employee details updated successfully!");

		} else {
			System.out.println("Invalid ID!!");
		}

		session.close();

	}

	@Override
	public void updateCompanyDetailsUsingempId() {
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee ID: ");
		int id = sc.nextInt();

		Employee emp = session.get(Employee.class, id);

		if (emp != null && emp.getCompany() != null) {

			Company cmp = emp.getCompany();
			System.out.println("Enter Company Name who want to update ::");
			cmp.setCmpName(sc.next());

			session.update(cmp);
			session.beginTransaction().commit();
			System.out.println("Company details updated successfully!");

		} else {
			System.out.println("No company found for this Employee ID!");
		}
		session.beginTransaction().commit();
		session.close();

	}

	@Override
	public void deleteEmployeeUsingempId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee ID to Delete: ");
		int id = sc.nextInt();

		Employee emp = session.get(Employee.class, id);

		if (emp != null) {

			Company cmp = emp.getCompany();
			if (cmp != null) {

				emp.setCompany(null);
				session.delete(emp);
				session.beginTransaction().commit();
			}

		} else {
			System.out.println("Invalid ID!!");
		}

		session.close();

	}

	@Override
	public void deleteCompanyUsingempId() {
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Employee ID who want to delete company details :: ");
		int id = sc.nextInt();

		Employee emp = session.get(Employee.class, id);

		if (emp != null && emp.getCompany() != null) {
			Company cmp = emp.getCompany();
			if (cmp != null) {
				emp.setCompany(null);
				session.delete(cmp);
				session.beginTransaction().commit();

			}
		} else {
			System.out.println("No company found for this Employee ID!");
		}

		session.close();
	}

}
