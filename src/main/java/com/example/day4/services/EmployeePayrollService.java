package com.example.day4.services;

import com.example.day4.Repository.EmployeePayrollRepository;
import com.example.day4.dto.EmployeePayrollDTO;
import com.example.day4.exceptions.EmployeePayrollException;
import com.example.day4.models.EmployeePayrollData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
    @Autowired
    private EmployeePayrollRepository employeeRepository;
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeeRepository
                .findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with employeeId"+empId + " does not exists..!!"));
    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return employeeRepository.findEmployeePayrollDepartment(department);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empPayrollDTO);
        log.debug("Emp Data :" +employeePayrollData.toString());
        return employeeRepository.save(employeePayrollData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.updateEmployeePayrollData(empPayrollDTO);
        return employeeRepository.save(employeePayrollData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeeRepository.delete(employeePayrollData);
    }
}
