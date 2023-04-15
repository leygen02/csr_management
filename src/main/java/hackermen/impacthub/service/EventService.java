package hackermen.impacthub.service;

import hackermen.impacthub.domain.Event;
import hackermen.impacthub.model.EventDTO;
import hackermen.impacthub.repos.EventRepository;
import hackermen.impacthub.util.NotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventDTO> findAll() {
        final List<Event> events = eventRepository.findAll(Sort.by("eventID"));
        return events.stream()
                .map((event) -> mapToDTO(event, new EventDTO()))
                .toList();
    }

    public EventDTO get(final UUID eventID) {
        return eventRepository.findById(eventID)
                .map(event -> mapToDTO(event, new EventDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public UUID create(final EventDTO eventDTO) {
        final Event event = new Event();
        mapToEntity(eventDTO, event);
        return eventRepository.save(event).getEventID();
    }

    public void update(final UUID eventID, final EventDTO eventDTO) {
        final Event event = eventRepository.findById(eventID)
                .orElseThrow(NotFoundException::new);
        mapToEntity(eventDTO, event);
        eventRepository.save(event);
    }

    public void delete(final UUID eventID) {
        eventRepository.deleteById(eventID);
    }

    private EventDTO mapToDTO(final Event event, final EventDTO eventDTO) {
        eventDTO.setEventID(event.getEventID());
        eventDTO.setEventName(event.getEventName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setDeadline(event.getDeadline());
        eventDTO.setLocation(event.getLocation());
        eventDTO.setCapacity(event.getCapacity());
        eventDTO.setEmployeeList(event.getEmployeeList());
        return eventDTO;
    }

    private Event mapToEntity(final EventDTO eventDTO, final Event event) {
        event.setEventName(eventDTO.getEventName());
        event.setDescription(eventDTO.getDescription());
        event.setDeadline(eventDTO.getDeadline());
        event.setLocation(eventDTO.getLocation());
        event.setCapacity(eventDTO.getCapacity());
        event.setEmployeeList(eventDTO.getEmployeeList());
        return event;
    }

}
