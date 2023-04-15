package hackermen.impacthub.repos;

import hackermen.impacthub.domain.Employee;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
