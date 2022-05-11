package controllers;

import dto.EmployeePayrollDTO;
import dto.ResponseDTO;
import models.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1,new EmployeePayrollDTO("Ganesh" , 40000));
        ResponseDTO respDTO = new ResponseDTO("Get call Success",employeePayrollData);
        return new ResponseEntity<ResponseDTO >(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId")  int empId){
        return new ResponseEntity<String>("Get Call Success for id:"+ empId , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
        return new ResponseEntity<String>("Created Employee Payroll Data for :"+ empPayrollDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
        return new ResponseEntity<String>("Updated Employee Payroll Data for :"+ empPayrollDTO, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId){
        return new ResponseEntity<String>("Delete Call Success for Id:"+ empId , HttpStatus.OK);
    }

}
