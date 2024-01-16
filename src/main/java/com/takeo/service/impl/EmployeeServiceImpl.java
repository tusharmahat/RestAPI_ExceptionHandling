package com.takeo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.entity.Employee;
import com.takeo.repo.EmployeeRepo;
import com.takeo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo daoImpl;

	@Override
	public Employee create(Employee emp) {
		return daoImpl.save(emp);
	}

	@Override
	public Optional<Employee> read(Long eid) {

		return daoImpl.findById(eid);
	}

	@Override
	public List<Employee> readAll() {
		return daoImpl.findAll();
	}

	@Override
	public Employee update(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long eid) {
		daoImpl.deleteById(eid);
		return false;
	}

}
