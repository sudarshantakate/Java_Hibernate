package com.dao;

public interface ServiceInDao {

	
	void createEmployeeOnlyInDao();
    void createDepartmentWithEmployeeInDao();
    void createDepartmentOnlyInDao();
    void readAllDetailsInDao();
    void readEmployeeWithDepartmentIdInDao();
    void readDepartmentWithDepartmentIdInDao();
    void updateAllDetailsInDao();
    void updateEmployeeWithDepartmentIdInDao();
    void updateDepartmentWithDepartmentIdInDao();
    void deleteAllDetails();
    void deleteEmployeeWithDepartmentIdInDao();
}
