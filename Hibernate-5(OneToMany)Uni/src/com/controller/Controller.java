package com.controller;

import java.util.Scanner;

import com.serviceimpl.StudentServiceImpl;

public class Controller {
	public static void main(String[] args) {
		boolean flag = true;
		StudentServiceImpl student = new StudentServiceImpl();
		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println("|----------WELCOME----------|");
			System.out.println("1. Add Student");
			System.out.println("2. Display Student Details Using Sid");
			System.out.println("3. Display Subject Details Using Sid");
			System.out.println("4. Update Student Details Using Sid");
			System.out.println("5. Update Subject Details Using Sid");
			System.out.println("6. Delete Student Details Using Sid");
			System.out.println("7. Delete Adhar Details Using Sid");
			System.out.println("8. Exit");
			System.out.println("Enter Your Choice : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				student.addStudent();
				break;
			case 2:
				student.getStudentOnlyUsingsid();
				break;
			case 3:
				student.getSubjectOnlyUsingsid();
				break;
			case 4:
				student.updateStudentDetailsUsingsid();
				break;
			case 5:
				student.updateSubjectDetailsUsingsid();
				break;
			case 6:
				student.deleteStudentOnlyUsingsid();
				break;
			case 7:
				student.deleteSubjectOnlyUsingsid();
				break;
			case 8:
				flag = false;
				System.out.println("-----Thank You For Visiting-----");
				break;
			default:
				System.out.println("Invalid Choice Please Enter valid choice....!!!");
				break;
			}
		}
	}
}