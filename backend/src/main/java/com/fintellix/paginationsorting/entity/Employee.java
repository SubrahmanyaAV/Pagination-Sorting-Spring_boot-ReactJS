package com.fintellix.paginationsorting.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	
	@Column(name = "name", nullable = false, length = 25)
	private String empName;
	
	@Column(name = "salary", nullable = false, length = 255)
	private double empSal;
	
	@Column(name = "address", nullable = false, length = 100)
	private String empAddress;
	
	@Column(name = "email", nullable = false, length = 50)
	private String empEmail;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

	public Employee() {
		super();
	}

	public Employee(Long empId, String empName, double empSal, String empAddress, String empEmail,
			Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empAddress = empAddress;
		this.empEmail = empEmail;
		this.department = department;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empAddress=" + empAddress
				+ ", empEmail=" + empEmail + ", department=" + department + "]";
	}
	
}
