package dev.abraham.employee_service.request;

import dev.abraham.employee_service.model.Gender;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record EmployeeRequest(
              String first_name,
              String last_name,
              @Past(message = "Birth date needs to be past")
              LocalDate birth_date,
              @PastOrPresent(message = "Hire date needs to be past or present")
              LocalDate hire_date,
              Gender gender
) {
}
