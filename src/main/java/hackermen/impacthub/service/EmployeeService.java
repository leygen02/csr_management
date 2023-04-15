package hackermen.impacthub.service;

import hackermen.impacthub.domain.Employee;
import hackermen.impacthub.model.EmployeeDTO;
import hackermen.impacthub.repos.EmployeeRepository;
import hackermen.impacthub.util.NotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> findAll() {
        final List<Employee> employees = employeeRepository.findAll(Sort.by("employeeID"));
        return employees.stream()
                .map((employee) -> mapToDTO(employee, new EmployeeDTO()))
                .toList();
    }

    public EmployeeDTO get(final UUID employeeID) {
        return employeeRepository.findById(employeeID)
                .map(employee -> mapToDTO(employee, new EmployeeDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public UUID create(final EmployeeDTO employeeDTO) {
        final Employee employee = new Employee();
        mapToEntity(employeeDTO, employee);
        return employeeRepository.save(employee).getEmployeeID();
    }

    public void update(final UUID employeeID, final EmployeeDTO employeeDTO) {
        final Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(NotFoundException::new);
        mapToEntity(employeeDTO, employee);
        employeeRepository.save(employee);
    }

    public void delete(final UUID employeeID) {
        employeeRepository.deleteById(employeeID);
    }

    private EmployeeDTO mapToDTO(final Employee employee, final EmployeeDTO employeeDTO) {
        employeeDTO.setEmployeeID(employee.getEmployeeID());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setAttendanceRate(employee.getAttendanceRate());
        employeeDTO.setPrevEnrolled(employee.getPrevEnrolled());
        employeeDTO.setEmailID(employee.getEmailID());
        return employeeDTO;
    }

    private Employee mapToEntity(final EmployeeDTO employeeDTO, final Employee employee) {
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setAttendanceRate(employeeDTO.getAttendanceRate());
        employee.setPrevEnrolled(employeeDTO.getPrevEnrolled());
        employee.setEmailID(employeeDTO.getEmailID());
        return employee;
    }

}
