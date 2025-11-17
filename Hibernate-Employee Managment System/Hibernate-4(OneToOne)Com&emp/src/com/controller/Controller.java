package com.controller;

import com.serviceimpl.*;
import com.service.*;

public class Controller {

	public static void main(String[] args) {

		EmployeeService empsc = new EmployeeServiceImpl();

//		empsc.addEmployeeWithCompany();
//		empsc.getEmployeeUsingempId();
//		empsc.getCompanyUsingempId();
//		empsc.updateEmployeeDetailsUsingempId();
//		empsc.updateCompanyDetailsUsingempId();
//		empsc.deleteEmployeeUsingempId();
		empsc.deleteCompanyUsingempId();
	}
}
