package com.fintellix.paginationsorting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fintellix.paginationsorting.entity.Employee;
import com.fintellix.paginationsorting.form.EmployeeForm;
import com.fintellix.paginationsorting.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/pagination-sorting/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/pagination-sorting/employees-with-department")
	public ResponseEntity<List<EmployeeForm>> getEmployeesWithDepartment() {
		List<EmployeeForm> employeesWithDepartments = employeeService.getAllEmployeesWithDepartment();
		return ResponseEntity.ok(employeesWithDepartments);
	}

	@GetMapping("/pagination-sorting/employees/{pageNo}/{pageSize}")
	public Page<Employee> employeePagination(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
		return employeeService.getEmployeePagination(pageNo, pageSize);
	}

	@GetMapping("/pagination-sorting/employees/{pageNo}/{pageSize}/{sort}")
	public Page<Employee> employeePagingAndSort(@PathVariable Integer pageNo, @PathVariable Integer pageSize,
			@PathVariable String sort) {
		return employeeService.getEmployeePagingAndSort(pageNo, pageSize, sort);
	}
	
	@GetMapping("/pagination-sorting/employees/{pageNo}/{pageSize}/{sort}/{direction}")
	public Page<Employee> employeePagingAndSort(
	    @PathVariable Integer pageNo,
	    @PathVariable Integer pageSize,
	    @PathVariable String sort,
	    @PathVariable String direction) {
	    return employeeService.getEmployeePagingAndSort(pageNo, pageSize, sort, direction);
	}

}
