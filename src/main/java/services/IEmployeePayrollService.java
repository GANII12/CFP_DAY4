package services;

import dto.EmployeePayrollDTO;
import models.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId , EmployeePayrollDTO empPayrollDTO);

    void deleteEmployeePayrollData(int empId);
}
