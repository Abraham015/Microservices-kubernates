package dev.abraham.employee_service.controller;

import dev.abraham.employee_service.request.EmployeeRequest;
import dev.abraham.employee_service.response.EmployeeResponse;
import dev.abraham.employee_service.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        return ResponseEntity.ok(employeeService.createEmployee(employeeRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/{employee_id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Integer employee_id){
        try {
            return ResponseEntity.ok(employeeService.getEmployeeById(employee_id));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{employee_id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Integer employee_id){
        employeeService.deleteEmployeeById(employee_id);
        return ResponseEntity.accepted().build();
    }
}