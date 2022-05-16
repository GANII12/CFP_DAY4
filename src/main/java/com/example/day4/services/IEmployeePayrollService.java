package com.example.day4.services;

import com.example.day4.dto.EmployeePayrollDTO;
import com.example.day4.models.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    List<EmployeePayrollData>getEmployeesByDepartment(String department);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId , EmployeePayrollDTO empPayrollDTO);

    void deleteEmployeePayrollData(int empId);
}
