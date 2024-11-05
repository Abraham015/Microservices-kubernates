package dev.abraham.employee_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employee_id;
    private String first_name;
    private String last_name;
    @Past(message = "Birth date needs to be past")
    private LocalDate birth_date;
    @PastOrPresent(message = "Birth date needs to be past")
    private LocalDate hire_date;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
