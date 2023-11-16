import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HeaderComponent from './HeaderComponent';
import EmployeeList from './EmployeeList'; 
import ErrorComponent from './ErrorComponent';
import WelcomeComponent from './WelcomeComponent';
import EmployeeWithDepartment from './EmployeeWithDepartment';

export default function PaginationAndSorting() {
  return (
    <BrowserRouter>
      <HeaderComponent />
      <Routes>
        <Route path="/" element={<WelcomeComponent />} />
        <Route path="/employees-with-department" element={<EmployeeWithDepartment />} />
        <Route path="/employees" element={<EmployeeList />} />
        <Route path="*" element={<ErrorComponent />} />
      </Routes>
    </BrowserRouter>
  );
}
