package hackermen.impacthub.rest;

import hackermen.impacthub.model.EmployeeDTO;
import hackermen.impacthub.service.EmployeeService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{employeeID}")
    public ResponseEntity<EmployeeDTO> getEmployee(
            @PathVariable(name = "employeeID") final UUID employeeID) {
        return ResponseEntity.ok(employeeService.get(employeeID));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<UUID> createEmployee(@RequestBody @Valid final EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.create(employeeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{employeeID}")
    public ResponseEntity<Void> updateEmployee(
            @PathVariable(name = "employeeID") final UUID employeeID,
            @RequestBody @Valid final EmployeeDTO employeeDTO) {
        employeeService.update(employeeID, employeeDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{employeeID}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable(name = "employeeID") final UUID employeeID) {
        employeeService.delete(employeeID);
        return ResponseEntity.noContent().build();
    }

}
