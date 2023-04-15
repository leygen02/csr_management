package com.CSR.CSR_MNG.repository;
import com.CSR.CSR_MNG.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpolyeeRepository extends JpaRepository<Employee,Integer> {
}