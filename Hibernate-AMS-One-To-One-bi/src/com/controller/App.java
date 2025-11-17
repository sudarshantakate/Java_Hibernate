package com.controller;

import java.util.Scanner;
import com.ams.service.Service;
import com.ams.service.ServiceImpl;

public class App {

    public static void main(String[] args) {
        Service cms = new ServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1.  Create Student With Address");
            System.out.println("2.  Create Address With Student");
            System.out.println("3.  Create Student Only");
            System.out.println("4.  Create Address Only");
            System.out.println();
            System.out.println("5.  Display All Details");
            System.out.println("6.  Display Student Using Student ID");
            System.out.println("7.  Display Student Using Address ID");
            System.out.println("8.  Display Address Using Student ID");
            System.out.println("9.  Display Address Using Address ID");
            System.out.println();
            System.out.println("10. Update All Details");
            System.out.println("11. Update Student Using Student ID");
            System.out.println("12. Update Student Using Address ID");
            System.out.println("13. Update Address Using Student ID");
            System.out.println("14. Update Address Using Address ID");
            System.out.println();
            System.out.println("15. Delete All Details");
            System.out.println("16. Delete Student Using Student ID");
            System.out.println("17. Delete Student Using Address ID");
            System.out.println("18. Delete Address Using Student ID");
            System.out.println("19. Delete Address Using Address ID");
            System.out.println("20. Exit");
            System.out.println("=========================");
            System.out.print("Enter your choice (1-20): ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 20.");
                continue;
            }

            switch (choice) {
                case 1:
                    cms.createStudentWithAddress();
                    break;
                case 2:
                    cms.createAddressWithStudent();
                    break;
                case 3:
                    cms.createStudentOnly();
                    break;
                case 4:
                    cms.createAddressOnly();
                    break;
                case 5:
                    cms.displayAllDetails();
                    break;
                case 6:
                    cms.displayStudentUsingStudentID();
                    break;
                case 7:
                    cms.displayStudentUsingAddressId();
                    break;
                case 8:
                    cms.displayAddressUsingStudentId();
                    break;
                case 9:
                    cms.displayAddressUsingAddressId();
                    break;
                case 10:
                    cms.updateAllDetails();
                    break;
                case 11:
                    cms.updateStudentUsingStudentID();
                    break;
                case 12:
                    cms.updateStudentUsingAddressId();
                    break;
                case 13:
                    cms.updateAddressUsingStudentId();
                    break;
                case 14:
                    cms.updateAddressUsingAddressId();
                    break;
                case 15:
                    cms.deleteAllDetails();
                    break;
                case 16:
                    cms.deleteStudentUsingStudentID();
                    break;
                case 17:
                    cms.deleteStudentUsingAddressId();
                    break;
                case 18:
                    cms.deleteAddressUsingStudentId();
                    break;
                case 19:
                    cms.deleteAddressUsingAddressId();
                    break;
                case 20:
                    System.out.println("Exiting program... Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 20.");
            }
        }
    }
}
