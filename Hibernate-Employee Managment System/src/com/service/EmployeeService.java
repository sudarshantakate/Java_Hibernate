package com.service;

public interface EmployeeService {

	
	    void createEmployeeOnlyInService();
	    void createDepartmentWithEmployeeInService();
	    void createDepartmentOnlyInService();
	    void readAllDetailsInService();
	    void readEmployeeWithDepartmentIdInService();
	    void readDepartmentWithDepartmentIdInService();
	    void updateAllDetailsInService();
	    void updateEmployeeWithDepartmentIdInService();
	    void updateDepartmentWithDepartmentIdInService();
	    void deleteAllDetails();
	    void deleteEmployeeWithDepartmentIdInService();
	
}
