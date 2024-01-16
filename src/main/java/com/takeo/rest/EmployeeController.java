package com.takeo.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takeo.dto.EmployeeDto;
import com.takeo.entity.Employee;
import com.takeo.exception.ResourceNotFound;
import com.takeo.service.EmployeeService;

@RestController
@Valid
@RequestMapping("api/employees/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService serviceImpl;

	@GetMapping("readall")
	public List<EmployeeDto> readAll() {
		List<Employee> all = serviceImpl.readAll();
		List<EmployeeDto> emps = new ArrayList<>();
		for (int i = 0; i < all.size(); i++) {
			EmployeeDto emp = new EmployeeDto();
			BeanUtils.copyProperties(all.get(i), emp);
			emps.add(emp);
		}
		return emps;
	}

	@GetMapping("read/{id}")
	public ResponseEntity<EmployeeDto> read(@PathVariable(value = "id") Long eid) throws ResourceNotFound {
		Employee emp = serviceImpl.read(eid)
				.orElseThrow(() -> new ResourceNotFound("Employee not found for this id: " + eid));
		EmployeeDto empDto = new EmployeeDto();

		BeanUtils.copyProperties(emp, empDto);

		return ResponseEntity.ok().body(empDto);
	}

	@PostMapping("create")
	public ResponseEntity<EmployeeDto> create(@Valid @RequestBody EmployeeDto employee)
			 {
		Employee emp = new Employee();

		BeanUtils.copyProperties(employee, emp);
		Employee saveEmp = serviceImpl.create(emp);
		BeanUtils.copyProperties(saveEmp, employee);

		return ResponseEntity.ok().body(employee);
	}

	@DeleteMapping("delete/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long eid) throws ResourceNotFound {
		Map<String, Boolean> response = new HashMap<>();
		Employee emp = serviceImpl.read(eid)
				.orElseThrow(() -> new ResourceNotFound("Employee of this id: " + eid + " not found."));
		if (emp != null) {
			serviceImpl.delete(eid);
			response.put("Deleted", Boolean.TRUE);
		} else {
			response.put("Not Deleted", Boolean.FALSE);
		}
		return response;
	}
}
