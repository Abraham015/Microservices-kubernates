package dev.abraham.employee_service.repository;

import dev.abraham.employee_service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
