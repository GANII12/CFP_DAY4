package com.example.day4.controllers;

import com.example.day4.dto.EmployeePayrollDTO;
import com.example.day4.dto.ResponseDTO;
import com.example.day4.models.EmployeePayrollData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.day4.services.IEmployeePayrollService;

import javax.persistence.Table;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("empPayroll")
@Slf4j
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;
    @GetMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get call Success",empDataList);
        return new ResponseEntity<ResponseDTO >(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId")  int empId){
        EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get call Success",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO>getEmployeePayrollData(@PathVariable("department") String department){
        List<EmployeePayrollData> empDataList = employeePayrollService.getEmployeesByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get Call for Id Successful" , empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO){
        log.debug("Employee DTO :"+ empPayrollDTO.toString());
        EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId ,@Valid @RequestBody EmployeePayrollDTO empPayrollDTO){
        EmployeePayrollData employeePayrollData =employeePayrollService.updateEmployeePayrollData(empId,empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully",employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully" , "Deleted Id :"+empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
