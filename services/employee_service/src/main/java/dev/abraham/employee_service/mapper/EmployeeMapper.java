package dev.abraham.employee_service.mapper;

import dev.abraham.employee_service.model.Employee;
import dev.abraham.employee_service.request.EmployeeRequest;
import dev.abraham.employee_service.response.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeMapper {

    public Employee toEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .birth_date(employeeRequest.birth_date())
                .first_name(employeeRequest.first_name())
                .last_name(employeeRequest.last_name())
                .gender(employeeRequest.gender())
                .hire_date(employeeRequest.hire_date())
                .build();
    }

    public EmployeeResponse toEmployeeResponse(Employee savedEmployee) {
        return new EmployeeResponse(
                savedEmployee.getEmployee_id(),
                savedEmployee.getFirst_name(),
                savedEmployee.getLast_name(),
                savedEmployee.getBirth_date(),
                savedEmployee.getHire_date(),
                savedEmployee.getGender()
        );
    }
}
