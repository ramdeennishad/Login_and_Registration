package com.example.registerlogin.service;

import com.example.registerlogin.dto.EmployeeDto;
import com.example.registerlogin.dto.LoginDto;
import com.example.registerlogin.response.LoginResponse;

public interface EmployeeService {
    String addEmployee(EmployeeDto employeeDto);

    LoginResponse loginEmployee(LoginDto loginDto);

}
