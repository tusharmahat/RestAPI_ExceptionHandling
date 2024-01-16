package com.takeo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takeo.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
