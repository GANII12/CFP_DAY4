package services;

import dto.EmployeePayrollDTO;
import models.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
//        List<EmployeePayrollData> employeePayrollList = new ArrayList<>() ;
//        employeePayrollList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Ganesh",10000)));
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
//        EmployeePayrollData employeePayrollData = null;
//        employeePayrollData = new EmployeePayrollData(empId , new EmployeePayrollDTO("Ganesh", 10000));
        return employeePayrollList.get(empId-1);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1,empPayrollDTO);
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
//        EmployeePayrollData employeePayrollData = null;
//        employeePayrollData = new EmployeePayrollData(empId,empPayrollDTO);
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeePayrollData.setName(empPayrollDTO.name);
        employeePayrollData.setSalary(empPayrollDTO.salary);
        employeePayrollList.set(empId-1,employeePayrollData);
        return employeePayrollData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.remove(empId-1);
    }
}
