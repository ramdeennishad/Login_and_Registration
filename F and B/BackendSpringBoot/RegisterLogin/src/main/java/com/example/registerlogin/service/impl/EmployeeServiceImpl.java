package com.example.registerlogin.service.impl;

import com.example.registerlogin.dto.EmployeeDto;
import com.example.registerlogin.dto.LoginDto;
import com.example.registerlogin.entity.Employee;
import com.example.registerlogin.repository.EmployeeRepository;
import com.example.registerlogin.response.LoginResponse;
import com.example.registerlogin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        System.out.println("rammmm");
        Employee employee = new Employee(

                null,

                employeeDto.getEmployeename(),
                employeeDto.getEmail(),
                this.passwordEncoder.encode(employeeDto.getPassword())
        );
        System.out.println("gjdkslkfjjdfk");

        employeeRepository.save(employee);
        return employee.getEmployeename();
    }

    EmployeeDto employeeDto;

    @Override
    public LoginResponse loginEmployee(LoginDto loginDto) {
        String msg = "";
        Employee employee1 = employeeRepository.findByEmail(loginDto.getEmail());
        if (employee1 != null) {
            String password = loginDto.getPassword();
            String encodePassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodePassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exits", false);
        }
    }
}








