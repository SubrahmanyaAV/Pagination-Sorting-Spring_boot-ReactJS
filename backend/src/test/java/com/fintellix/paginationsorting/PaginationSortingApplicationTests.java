package com.fintellix.paginationsorting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import org.junit.jupiter.api.Assertions;

import com.fintellix.paginationsorting.entity.Employee;
import com.fintellix.paginationsorting.service.EmployeeService;

@SpringBootTest
class PaginationSortingApplicationTests {
	
	@Autowired
	private EmployeeService employeeService;

	@Test
	public void testPagingAndSorting() {
		int pageNo = 0;
        int pageSize = 4;
        String sortField = "empName";

        Page<Employee> result = employeeService.getEmployeePagingAndSort(pageNo, pageSize, sortField);

        Assertions.assertEquals(pageSize, result.getSize());
	}

}
