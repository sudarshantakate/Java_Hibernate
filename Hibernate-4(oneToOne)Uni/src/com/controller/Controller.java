package com.controller;

import com.service.PersionService;
import com.serviceimpl.PersionServiceImpl;

public class Controller {

	public static void main(String[] args) {

		PersionService ps = new PersionServiceImpl();

		ps.addPersionWithAadhar();
		ps.getPersionOnlyUsingPid();
		ps.getAadharOnlyUsingPid();
		ps.updatePersionDetailsUsingPid();
		ps.deletePersionDetailsUsingPid();
		ps.deleteAadharDetailsUsingPid();
	}
}
