package com.fintellix.paginationsorting.form;

public class EmployeeForm {

	private Long empId;
	private String empName;
	private Double empSal;
	private String empAddress;
	private String empEmail;
	private Long deptId;
	private String deptName;

	public EmployeeForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeForm(Long empId, String empName, Double empSal, String empAddress, String empEmail, Long deptId,
			String deptName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empAddress = empAddress;
		this.empEmail = empEmail;
		this.deptId = deptId;
		this.deptName = deptName;
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

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
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

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
