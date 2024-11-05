package dev.abraham.employee_service.service;

import dev.abraham.employee_service.mapper.EmployeeMapper;
import dev.abraham.employee_service.model.Employee;
import dev.abraham.employee_service.repository.EmployeeRepository;
import dev.abraham.employee_service.request.EmployeeRequest;
import dev.abraham.employee_service.response.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = employeeMapper.toEmployee(employeeRequest);
        Employee savedEmployee=employeeRepository.save(employee);
        return employeeMapper.toEmployeeResponse(savedEmployee);
    }
}
