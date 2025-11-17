package com.controller;

import java.util.Scanner;
import com.service.Userserviceimpl;

public class Controller {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Userserviceimpl usi = new Userserviceimpl();

		boolean flag = true;

		while (flag) {
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*USER MANAGEMENT SYSTEM-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println("----------------------------------");
			System.out.println("1.Add Users");
			System.out.println("2.Display User Data ");
			System.out.println("3.Update User");
			System.out.println("4.Remove User");
			System.out.println("5.Sort User Salary");
			System.out.println("6.Exit");
			System.out.println("----------------------------------");
			System.out.println("Choose the correct option: ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				usi.addUser();
				break;
			case 2:
				usi.displaySingleUser();
				break;

			case 3:
				usi.updateUser();
				break;

			case 4:
				usi.deleteUser();
				break;

			case 5:
				usi.sortUsersBySalary();
				break;

			case 6:
				flag = false;
				break;

			default:
				System.out.println("Invalid Choice please try again!!");
				break;
			}

		}

	}

}
