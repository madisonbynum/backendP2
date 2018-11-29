package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Employee;
import com.revature.repositories.EmployeeRepository;

@Service
public class LoginService {
	EmployeeRepository empRepo;
	
	@Autowired
	public LoginService(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}
	
	@Transactional
	public Employee create(Employee emp) {
		empRepo.insert(emp);
		return emp;
	}

}
