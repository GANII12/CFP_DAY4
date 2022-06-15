package com.example.day4.models;

import com.example.day4.dto.EmployeePayrollDTO;
import lombok.Data;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "First_name")
    private String firstName;
    @Column(name = "Last_name")
    private String lastName;
    private String gender;
//    @ElementCollection
//    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private String department;
    private long salary;

    private LocalDate startdate;
    private String notes;
    private String profilePic;


    public EmployeePayrollData() {
    }

    public EmployeePayrollData( EmployeePayrollDTO empPayrollDTO) {
        this.updateEmployeePayrollData(empPayrollDTO);
    }
    public void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        this.firstName = empPayrollDTO.firstName;
        this.lastName = empPayrollDTO.lastName;
        this.gender = empPayrollDTO.gender;
        this.startdate = empPayrollDTO.startdate;
        this.department = empPayrollDTO.department;
        this.salary = empPayrollDTO.salary;
        this.notes = empPayrollDTO.notes;
        this.profilePic = empPayrollDTO.profilePic;
    }
}
