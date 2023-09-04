package io.impacthub.impacthub.rest;

import io.impacthub.impacthub.model.EmployeesDTO;
import io.impacthub.impacthub.service.EmployeesService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
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
@RequestMapping(value = "/api/employeess", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeesResource {

    private final EmployeesService employeesService;

    public EmployeesResource(final EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeesDTO>> getAllEmployeess() {
        return ResponseEntity.ok(employeesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeesDTO> getEmployees(@PathVariable(name = "id") final Integer id) {
        return ResponseEntity.ok(employeesService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Integer> createEmployees(
            @RequestBody @Valid final EmployeesDTO employeesDTO) {
        final Integer createdId = employeesService.create(employeesDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateEmployees(@PathVariable(name = "id") final Integer id,
            @RequestBody @Valid final EmployeesDTO employeesDTO) {
        employeesService.update(id, employeesDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteEmployees(@PathVariable(name = "id") final Integer id) {
        employeesService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
