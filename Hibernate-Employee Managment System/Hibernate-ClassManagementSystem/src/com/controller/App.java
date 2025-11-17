package com.controller;

import java.util.Scanner;

import com.service.CMSService;
import com.service.CMSServiceImpl;

public class App {

	public static void main(String[] args) {

		boolean flag = true;
		CMSService cms = new CMSServiceImpl();
		Scanner sc = new Scanner(System.in);

		while (flag) {

			System.out.println("----------------------------------------------------");
			System.out.println("|-------WELCOME TO CLASS MANAGEMENT SYSTEM-------|");
			System.out.println("1. Add Course");
			System.out.println("2. Display Course Details");
			System.out.println("3. Add Faculty");
			System.out.println("4. Display Faculty Details");
			System.out.println("5. Add Batch Details");
			System.out.println("6. Display Batch Details");
			System.out.println("7. Add Student");
			System.out.println("8. Display Student Details");
			System.out.println("9.Exit");
			System.out.println("----------------------------------------------------");
			System.out.println("Choose Correct Option: ");
			int ch = sc.nextInt();

			switch (ch) {

			case 1:
				cms.addCourse();// controller-----service-----dao layer-----database
				break;
			case 2:
				cms.displayCourseDetails();
				break;

			case 3:
				cms.addFaculty();
				break;
			case 4:
				cms.displayFacultyDetails();
				break;
			case 5:
				cms.addBatch();
				break;
			case 6:
				cms.displayBatchDetails();
				break;
			case 7:
				cms.addStudent();
				break;

			case 8:
				cms.displayStudentDetails();
				break;
			case 9:
				flag = false;
				break;
			default:
				System.out.println("Invalid Choice try Again!!");
				break;

			}
		}

	}
}
