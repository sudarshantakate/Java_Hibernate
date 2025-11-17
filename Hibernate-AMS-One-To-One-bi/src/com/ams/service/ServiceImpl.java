package com.ams.service;

import java.util.Scanner;
import com.model.Address;
import com.model.Student;
import com.ams.servicedao.ServiceDaoImpl;


public class ServiceImpl implements Service {

	ServiceDaoImpl dao = new ServiceDaoImpl();
    private final Scanner sc = new Scanner(System.in);

    // ------------------ Create ------------------
    @Override
    public void createStudentWithAddress() {
        Student stud = new Student();
        System.out.print("Enter Student Name: ");
        stud.setSname(sc.nextLine().trim());

        Address add = new Address();
        System.out.print("Enter Address Name: ");
        add.setAname(sc.nextLine().trim());

        // link both sides
        stud.setAddress(add);

        dao.createStudentWithAddressInDao(stud, add);
    }

    @Override
    public void createAddressWithStudent() {
        Address add = new Address();
        System.out.print("Enter Address Name: ");
        add.setAname(sc.nextLine().trim());

        Student stud = new Student();
        System.out.print("Enter Student Name: ");
        stud.setSname(sc.nextLine().trim());

        // link both sides
        stud.setAddress(add);

        dao.createAddressWithStudentInDao(add, stud);
    }

    @Override
    public void createStudentOnly() {
        Student stud = new Student();
        System.out.print("Enter Student Name: ");
        stud.setSname(sc.nextLine().trim());

        dao.createStudentOnlyInDao(stud);
    }

    @Override
    public void createAddressOnly() {
        Address add = new Address();
        System.out.print("Enter Address Name: ");
        add.setAname(sc.nextLine().trim());

        dao.createAddressOnlyInDao(add);
    }

    // ------------------ Display ------------------
    @Override
    public void displayAllDetails() {
        dao.displayAllDetailsInDao();
    }

    @Override
    public void displayStudentUsingStudentID() {
        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();
        dao.displayStudentUsingStudentIDInDao(sid);
    }

    @Override
    public void displayStudentUsingAddressId() {
        System.out.print("Enter Address ID: ");
        int aid = sc.nextInt();
        sc.nextLine();
        dao.displayStudentUsingAddressIdInDao(aid);
    }

    @Override
    public void displayAddressUsingStudentId() {
        System.out.print("Enter Student ID: ");
        int sid = sc.nextInt();
        sc.nextLine();
        dao.displayAddressUsingStudentIdInDao(sid);
    }

    @Override
    public void displayAddressUsingAddressId() {
        System.out.print("Enter Address ID: ");
        int aid = sc.nextInt();
        sc.nextLine();
        dao.displayAddressUsingAddressIdInDao(aid);
    }

    // ------------------ Update ------------------
    @Override
    public void updateAllDetails() {
        System.out.print("Enter Student ID to update: ");
        int sid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Student Name (leave blank to keep unchanged): ");
        String newSname = sc.nextLine().trim();
        if (newSname.isEmpty()) newSname = null;

        System.out.print("Enter new Address Name (leave blank to keep unchanged): ");
        String newAname = sc.nextLine().trim();
        if (newAname.isEmpty()) newAname = null;

        dao.updateAllDetailsInDao(sid, newSname, newAname);
    }

    @Override
    public void updateStudentUsingStudentID() {
        System.out.print("Enter Student ID to update: ");
        int sid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Student Name: ");
        String newSname = sc.nextLine().trim();
        if (newSname.isEmpty()) {
            System.out.println("Empty name provided. Update cancelled.");
            return;
        }

        dao.updateStudentUsingStudentIDInDao(sid, newSname);
    }

    @Override
    public void updateStudentUsingAddressId() {
        System.out.print("Enter Address ID to update its linked student: ");
        int aid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Student Name: ");
        String newSname = sc.nextLine().trim();
        if (newSname.isEmpty()) {
            System.out.println("Empty name provided. Update cancelled.");
            return;
        }

        dao.updateStudentUsingAddressIdInDao(aid, newSname);
    }

    @Override
    public void updateAddressUsingStudentId() {
        System.out.print("Enter Student ID whose address you want to update: ");
        int sid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Address Name: ");
        String newAname = sc.nextLine().trim();
        if (newAname.isEmpty()) {
            System.out.println("Empty address provided. Update cancelled.");
            return;
        }

        dao.updateAddressUsingStudentIdInDao(sid, newAname);
    }

    @Override
    public void updateAddressUsingAddressId() {
        System.out.print("Enter Address ID to update: ");
        int aid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new Address Name: ");
        String newAname = sc.nextLine().trim();
        if (newAname.isEmpty()) {
            System.out.println("Empty address provided. Update cancelled.");
            return;
        }

        dao.updateAddressUsingAddressIdInDao(aid, newAname);
    }

    // ------------------ Delete ------------------
    @Override
    public void deleteAllDetails() {
        System.out.print("Are you sure to delete ALL records? (yes/no): ");
        String confirm = sc.nextLine().trim();
        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Delete cancelled.");
            return;
        }
        dao.deleteAllDetailsInDao();
    }

    @Override
    public void deleteStudentUsingStudentID() {
        System.out.print("Enter Student ID to delete: ");
        int sid = sc.nextInt();
        sc.nextLine();

        System.out.print("Are you sure? (yes/no): ");
        String confirm = sc.nextLine().trim();
        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Delete cancelled.");
            return;
        }

        dao.deleteStudentUsingStudentIDInDao(sid);
    }

    @Override
    public void deleteStudentUsingAddressId() {
        System.out.print("Enter Address ID whose linked Student you want to delete: ");
        int aid = sc.nextInt();
        sc.nextLine();

        System.out.print("Are you sure? (yes/no): ");
        String confirm = sc.nextLine().trim();
        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Delete cancelled.");
            return;
        }

        dao.deleteStudentUsingAddressIdInDao(aid);
    }

    @Override
    public void deleteAddressUsingStudentId() {
        System.out.print("Enter Student ID whose Address you want to delete: ");
        int sid = sc.nextInt();
        sc.nextLine();

        System.out.print("Are you sure? (yes/no): ");
        String confirm = sc.nextLine().trim();
        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Delete cancelled.");
            return;
        }

        dao.deleteAddressUsingStudentIdInDao(sid);
    }

    @Override
    public void deleteAddressUsingAddressId() {
        System.out.print("Enter Address ID to delete: ");
        int aid = sc.nextInt();
        sc.nextLine();

        System.out.print("Are you sure? (yes/no): ");
        String confirm = sc.nextLine().trim();
        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Delete cancelled.");
            return;
        }

        dao.deleteAddressUsingAddressIdInDao(aid);
    }
}
