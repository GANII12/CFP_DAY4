package com.example.day4.dto;


import lombok.ToString;
import javax.validation.constraints.*;
import java.time.LocalDate;

public @ToString class EmployeePayrollDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee firstname Invalid")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee lastname Invalid")
    public String lastName;

    @Min(value = 500,message = "Min wage should be more than 500")
    public long salary;
    @Pattern(regexp = "male|female" , message = "Gender needs to be male or female")
    public String gender;
//    @JsonFormat(pattern = "dd MM yyyy")
//    @NotNull(message = "StartDate shoud Not be Empty")
//    @PastOrPresent(message = "startDate should be past or todays date")
    public LocalDate startdate;
    @NotBlank(message = "Note cannot be Empty")
    public String notes;

    @NotBlank(message = "profilePic cannot be Empty")
    public String profilePic;
    @NotNull(message = "department should Not be Empty")
    public String department;
}
