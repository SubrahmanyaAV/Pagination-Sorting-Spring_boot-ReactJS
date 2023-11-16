import React, { useState, useEffect } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

function EmployeeWithDepartment() {
    const [employeeWithDepartments, setEmployeeWithDepartments] = useState([]);
    const [pageNo, setPageNo] = useState(1);
    const [pageSize, setPageSize] = useState(10);
    const [sort, setSort] = useState('empId');
    const [sortDirection, setSortDirection] = useState('asc');
    const [totalPages, setTotalPages] = useState(0);

    useEffect(() => {
        fetchEmployeesWithDepartments();
    }, [pageNo, pageSize, sort, sortDirection]);

    const fetchEmployeesWithDepartments = async () => {
        try {
            const response = await axios.get(
                `http://localhost:8081/pagination-sorting/employees-with-department`
            );

            setEmployeeWithDepartments(response.data);
            setTotalPages(response.data.totalPages);
        } catch (error) {
            console.error('Error fetching employees with departments:', error);
        }
    };

    const handlePageChange = (newPage) => {
        if (newPage > 0 && newPage <= totalPages) {
            setPageNo(newPage);
        }
    };

    const handleSort = (column) => {
        setSort(column);
        setSortDirection(sortDirection === 'asc' ? 'desc' : 'asc');
    };

    const renderSortIndicator = (column) => {
        if (sort === column) {
            return sortDirection === 'asc' ? <span>&uarr;</span> : <span>&darr;</span>;
        }
        return null;
    };

    return (
        <div className="container mt-5">
            <h1 className="mb-4">Employee List with Department</h1>
            <table className="table">
                <thead>
                    <tr>
                        <th onClick={() => handleSort('empId')}>
                            ID {renderSortIndicator('empId')}
                        </th>
                        <th onClick={() => handleSort('empName')}>
                            Name {renderSortIndicator('empName')}
                        </th>
                        <th>Email</th>
                        <th onClick={() => handleSort('empSal')}>
                            Salary {renderSortIndicator('empSal')}
                        </th>
                        <th onClick={() => handleSort('empAddress')}>
                            Address {renderSortIndicator('empAddress')}
                        </th>
                        <th onClick={() => handleSort('deptName')}>
                            Department {renderSortIndicator('deptName')}
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {employeeWithDepartments.map((employee) => (
                        <tr key={employee.empId}>
                            <td>{employee.empId}</td>
                            <td>{employee.empName}</td>
                            <td>{employee.empEmail}</td>
                            <td>{employee.empSal}</td>
                            <td>{employee.empAddress}</td>
                            <td>{employee.deptName || 'N/A'}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div className="d-flex justify-content-between">
                <button className="btn btn-primary" onClick={() => handlePageChange(pageNo - 1)}>
                    Previous
                </button>
                <span className="align-self-center">
                    Page {pageNo} of {totalPages}
                </span>
                <button className="btn btn-primary" onClick={() => handlePageChange(pageNo + 1)}>
                    Next
                </button>
            </div>
        </div>
    );
}

export default EmployeeWithDepartment;
