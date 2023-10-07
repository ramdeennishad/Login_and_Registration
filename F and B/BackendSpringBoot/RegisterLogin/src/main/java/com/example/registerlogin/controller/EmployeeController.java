package com.example.registerlogin.controller;


import com.example.registerlogin.dto.EmployeeDto;
import com.example.registerlogin.dto.LoginDto;
import com.example.registerlogin.response.LoginResponse;
import com.example.registerlogin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping(path="/save")
   public String saveEmployee(@RequestBody EmployeeDto employeeDto){
       String id =employeeService.addEmployee(employeeDto);
       return id;
   }


   @PostMapping(path="/login")
   public ResponseEntity<?> LoginEmployee(@RequestBody LoginDto loginDto){
        LoginResponse loginResponse=employeeService.loginEmployee(loginDto);

        return ResponseEntity.ok(loginResponse);
   }




}
