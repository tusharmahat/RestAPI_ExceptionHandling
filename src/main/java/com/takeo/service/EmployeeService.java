package com.takeo.service;

import java.util.List;
import java.util.Optional;

import com.takeo.entity.Employee;


public interface EmployeeService {
	Employee create(Employee emp);

	Optional<Employee> read(Long eid);

	List<Employee> readAll();

	Employee update(Employee emp);

	boolean delete(Long edi);
}
