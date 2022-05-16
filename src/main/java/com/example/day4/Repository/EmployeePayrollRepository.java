package com.example.day4.Repository;

import com.example.day4.models.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {
    @Query(value = "select * from employee_department where employee_id and department = :department",nativeQuery = true)
    List<EmployeePayrollData> findEmployeePayrollDepartment(String department);

}
