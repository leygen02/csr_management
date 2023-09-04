package io.impacthub.impacthub.repos;

import io.impacthub.impacthub.domain.Employees;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
}
