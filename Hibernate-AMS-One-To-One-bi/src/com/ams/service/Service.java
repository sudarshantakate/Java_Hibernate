package com.ams.service;

/**
 * Service layer interface for Student - Address management.
 * Service methods are user-facing (they typically interact with the user
 * (Scanner) and call corresponding DAO methods).
 */
public interface Service {

    // Create methods
    void createStudentWithAddress();
    void createAddressWithStudent();
    void createStudentOnly();
    void createAddressOnly();

    // Display methods
    void displayAllDetails();
    void displayStudentUsingStudentID();
    void displayStudentUsingAddressId();
    void displayAddressUsingStudentId();
    void displayAddressUsingAddressId();

    // Update methods
    void updateAllDetails();
    void updateStudentUsingStudentID();
    void updateStudentUsingAddressId();
    void updateAddressUsingStudentId();
    void updateAddressUsingAddressId();

    // Delete methods
    void deleteAllDetails();
    void deleteStudentUsingStudentID();
    void deleteStudentUsingAddressId();
    void deleteAddressUsingStudentId();
    void deleteAddressUsingAddressId();
}
