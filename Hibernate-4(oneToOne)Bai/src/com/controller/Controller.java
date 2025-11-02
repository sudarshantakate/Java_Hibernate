package com.controller;

import java.util.Scanner;

import com.serviceimpl.PersonServiceImpl;

public class Controller {
	public static void main(String[] args) {
		boolean flag = true;
		PersonServiceImpl person = new PersonServiceImpl();
		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println("|----------WELCOME----------|");
			System.out.println("1. Add Person");
			System.out.println("2. Display Person Details Using Pid");
			System.out.println("3. Display Adhar Details Using Pid");
			System.out.println("4. Update Person Details Using Pid");
			System.out.println("5. Update Adhar Details Using Pid");
			System.out.println("6. Delete Person Details Using Pid");
			System.out.println("7. Delete Adhar Details Using Pid");
			System.out.println("8. Display Person Details Using Aid");
			System.out.println("9. Display Adhar Details Using Aid");
			System.out.println("10 Update Person Details Using Aid");
			System.out.println("11. Update Adhar Details Using Aid");
			System.out.println("12. Delete Person Details Using Aid");
			System.out.println("13. Delete Adhar Details Using Aid");
			System.out.println("14. Exit");
			System.out.println("Enter Your Choice : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				person.addperson();
				break;
			case 2:
				person.getPersonOnlyUsingPid();
				break;
			case 3:
				person.getAdharOnlyUsingPid();
				break;
			case 4:
				person.updatePersonDetailsUsingPid();
				break;
			case 5:
				person.updateAdharDetailsUsingPid();
				break;
			case 6:
				person.deletePersonOnlyUsingPid();
				break;
			case 7:
				person.deleteAdharOnlyUsingPid();
				break;
			case 8:
				person.getPersonOnlyUsingAid();
				break;
			case 9:
				person.getAdharOnlyUsingAid();
				break;
			case 10:
				person.updatePersonDetailsUsingAid();
				break;
			case 11:
				person.updateAdharDetailsUsingAid();
				break;
			case 12:
				person.deletePersonOnlyUsingAid();
				break;
			case 13:
				person.deleteAdharOnlyUsingAid();
				break;
			case 14:
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