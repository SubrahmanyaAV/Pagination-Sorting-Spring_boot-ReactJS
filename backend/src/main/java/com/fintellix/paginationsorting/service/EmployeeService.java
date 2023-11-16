package com.fintellix.paginationsorting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fintellix.paginationsorting.entity.Employee;
import com.fintellix.paginationsorting.form.EmployeeForm;
import com.fintellix.paginationsorting.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Page<Employee> getEmployees(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}

	public Page<Employee> getEmployeePagination(Integer pageNo, Integer pageSize) {
		Sort sort = Sort.by(Sort.Direction.ASC, "empName");
		// name property in ascending
		// Pageable pageable = PageRequest.of(pageNo, pageSize); //just for pagination
		// Zero indexing
		Pageable pagingAndSort = PageRequest.of(pageNo, pageSize, sort); // for both paging n sort
		return employeeRepository.findAll(pagingAndSort);
	}

	// instead of hard coding
	public Page<Employee> getEmployeePagingAndSort(Integer pageNo, Integer pageSize, String sort) {
		// Page Number one indexing
		Pageable pagingAndSort = PageRequest.of(pageNo - 1, pageSize, Sort.Direction.ASC, sort);
		return employeeRepository.findAll(pagingAndSort);
	}
	
	//sorting direction
	public Page<Employee> getEmployeePagingAndSort(Integer pageNo, Integer pageSize, String sort, String direction) {
	    Pageable pagingAndSort = PageRequest.of(pageNo - 1, pageSize, Sort.Direction.fromString(direction), sort);
	    return employeeRepository.findAll(pagingAndSort);
	}

	public List<EmployeeForm> getAllEmployeesWithDepartment() {
		List<EmployeeForm> employeeList = new ArrayList<>();
		List<Employee> employees = employeeRepository.findAll(); // Fetch employees

		for (Employee employee : employees) {
			EmployeeForm dto = new EmployeeForm();
			dto.setEmpId(employee.getEmpId());
			dto.setEmpName(employee.getEmpName());
			dto.setEmpSal(employee.getEmpSal());
			dto.setEmpAddress(employee.getEmpAddress());
			dto.setEmpEmail(employee.getEmpEmail());
			dto.setDeptId(employee.getDepartment().getDeptId());
			dto.setDeptName(employee.getDepartment().getDeptName());
			employeeList.add(dto);
		}

		return employeeList;
	}
}
