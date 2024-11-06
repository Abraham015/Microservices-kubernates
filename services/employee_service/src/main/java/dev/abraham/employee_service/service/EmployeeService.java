package dev.abraham.employee_service.service;

import dev.abraham.employee_service.mapper.EmployeeMapper;
import dev.abraham.employee_service.model.Employee;
import dev.abraham.employee_service.repository.EmployeeRepository;
import dev.abraham.employee_service.request.EmployeeRequest;
import dev.abraham.employee_service.response.EmployeeResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<EmployeeResponse> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toEmployeeResponse)
                .toList();
    }

    public EmployeeResponse getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employeeMapper::toEmployeeResponse)
                .orElseThrow(()->new EntityNotFoundException("Employee does not exist"));
    }

    public void deleteEmployeeById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
