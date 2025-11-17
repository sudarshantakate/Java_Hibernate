package com.ams.servicedao;

import com.model.Address;
import com.model.Student;

/**
 * DAO interface for Student <-> Address operations.
 * Method signatures include the parameters used by the Service layer
 * implementations provided earlier.
 */
public interface ServiceDao {

    // Create
    void createStudentWithAddressInDao(Student stud, Address add);
    void createAddressWithStudentInDao(Address add, Student stud);
    void createStudentOnlyInDao(Student stud);
    void createAddressOnlyInDao(Address add);

    // Display / Read
    void displayAllDetailsInDao();
    void displayStudentUsingStudentIDInDao(int sid);
    void displayStudentUsingAddressIdInDao(int aid);
    void displayAddressUsingStudentIdInDao(int sid);
    void displayAddressUsingAddressIdInDao(int aid);

    // Update
    /**
     * Update both student name and address name for a student identified by sid.
     * Passing null for newSname or newAname means "leave that field unchanged".
     */
    void updateAllDetailsInDao(int sid, String newSname, String newAname);
    void updateStudentUsingStudentIDInDao(int sid, String newSname);
    void updateStudentUsingAddressIdInDao(int aid, String newSname);
    void updateAddressUsingStudentIdInDao(int sid, String newAname);
    void updateAddressUsingAddressIdInDao(int aid, String newAname);

    // Delete
    void deleteAllDetailsInDao();
    void deleteStudentUsingStudentIDInDao(int sid);
    void deleteStudentUsingAddressIdInDao(int aid);
    void deleteAddressUsingStudentIdInDao(int sid);
    void deleteAddressUsingAddressIdInDao(int aid);
}
