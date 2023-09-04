package io.impacthub.impacthub.service;

import io.impacthub.impacthub.domain.Employees;
import io.impacthub.impacthub.domain.Events;
import io.impacthub.impacthub.model.EmployeesDTO;
import io.impacthub.impacthub.repos.EmployeesRepository;
import io.impacthub.impacthub.repos.EventsRepository;
import io.impacthub.impacthub.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class EmployeesService {

    private final EmployeesRepository employeesRepository;
    private final EventsRepository eventsRepository;

    public EmployeesService(final EmployeesRepository employeesRepository,
            final EventsRepository eventsRepository) {
        this.employeesRepository = employeesRepository;
        this.eventsRepository = eventsRepository;
    }

    public List<EmployeesDTO> findAll() {
        final List<Employees> employeess = employeesRepository.findAll(Sort.by( "id"));
        return employeess.stream()
                .map(employees -> mapToDTO(employees, new EmployeesDTO()))
                .toList();
    }

    public EmployeesDTO get(final Integer id) {
        return employeesRepository.findById(id)
                .map(employees -> mapToDTO(employees, new EmployeesDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final EmployeesDTO employeesDTO) {
        final Employees employees = new Employees();
        mapToEntity(employeesDTO, employees);
        return employeesRepository.save(employees).getId();
    }

    public void update(final Integer id, final EmployeesDTO employeesDTO) {
        final Employees employees = employeesRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(employeesDTO, employees);
        employeesRepository.save(employees);
    }

    public void delete(final Integer id) {
        employeesRepository.deleteById(id);
    }

    private EmployeesDTO mapToDTO(final Employees employees, final EmployeesDTO employeesDTO) {
        employeesDTO.setId(employees.getId());
        employeesDTO.setFirstname(employees.getFirstname());
        employeesDTO.setLastname(employees.getLastname());
        employeesDTO.setEmail(employees.getEmail());
        employeesDTO.setEvent(employees.getEvent() == null ? null : employees.getEvent().getId());
        employeesDTO.setOrganiser(employees.getOrganiser() == null ? null : employees.getOrganiser().getId());
        return employeesDTO;
    }

    private Employees mapToEntity(final EmployeesDTO employeesDTO, final Employees employees) {
        employees.setFirstname(employeesDTO.getFirstname());
        employees.setLastname(employeesDTO.getLastname());
        employees.setEmail(employeesDTO.getEmail());
        final Events event = employeesDTO.getEvent() == null ? null : eventsRepository.findById(employeesDTO.getEvent())
                .orElseThrow(() -> new NotFoundException("event not found"));
        employees.setEvent(event);
        final Events organiser = employeesDTO.getOrganiser() == null ? null : eventsRepository.findById(employeesDTO.getOrganiser())
                .orElseThrow(() -> new NotFoundException("organiser not found"));
        employees.setOrganiser(organiser);
        return employees;
    }

}
