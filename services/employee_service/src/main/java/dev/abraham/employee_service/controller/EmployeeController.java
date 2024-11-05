package dev.abraham.employee_service.controller;

import dev.abraham.employee_service.request.EmployeeRequest;
import dev.abraham.employee_service.response.EmployeeResponse;
import dev.abraham.employee_service.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        return ResponseEntity.ok(employeeService.createEmployee(employeeRequest));
    }
}
