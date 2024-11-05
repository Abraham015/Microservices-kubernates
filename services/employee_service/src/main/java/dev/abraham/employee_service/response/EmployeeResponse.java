package dev.abraham.employee_service.response;

import dev.abraham.employee_service.model.Gender;

import java.time.LocalDate;

public record EmployeeResponse(
        Integer id,
        String first_name,
        String last_name,
        LocalDate birth_date,
        LocalDate hire_date,
        Gender gender
) {
}
