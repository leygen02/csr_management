package io.impacthub.impacthub.service;

import io.impacthub.impacthub.domain.Events;
import io.impacthub.impacthub.model.EventsDTO;
import io.impacthub.impacthub.repos.EventsRepository;
import io.impacthub.impacthub.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class EventsService {

    private final EventsRepository eventsRepository;

    public EventsService(final EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public List<EventsDTO> findAll() {
        final List<Events> eventss = eventsRepository.findAll(Sort.by("id"));
        return eventss.stream()
                .map(events -> mapToDTO(events, new EventsDTO()))
                .toList();
    }

    public EventsDTO get(final Integer id) {
        return eventsRepository.findById(id)
                .map(events -> mapToDTO(events, new EventsDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final EventsDTO eventsDTO) {
        final Events events = new Events();
        mapToEntity(eventsDTO, events);
        return eventsRepository.save(events).getId();
    }

    public void update(final Integer id, final EventsDTO eventsDTO) {
        final Events events = eventsRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(eventsDTO, events);
        eventsRepository.save(events);
    }

    public void delete(final Integer id) {
        eventsRepository.deleteById(id);
    }

    private EventsDTO mapToDTO(final Events events, final EventsDTO eventsDTO) {
        eventsDTO.setId(events.getId());
        eventsDTO.setName(events.getName());
        eventsDTO.setLocation(events.getLocation());
        eventsDTO.setDescription(events.getDescription());
        eventsDTO.setCapacity(events.getCapacity());
        eventsDTO.setDate(events.getDate());
        eventsDTO.setVisibility(events.getVisibility());
        eventsDTO.setSeatsFilled(events.getSeatsFilled());
        eventsDTO.setCriteria(events.getCriteria());
        return eventsDTO;
    }

    private Events mapToEntity(final EventsDTO eventsDTO, final Events events) {
        events.setName(eventsDTO.getName());
        events.setLocation(eventsDTO.getLocation());
        events.setDescription(eventsDTO.getDescription());
        events.setCapacity(eventsDTO.getCapacity());
        events.setDate(eventsDTO.getDate());
        events.setVisibility(eventsDTO.getVisibility());
        events.setSeatsFilled(eventsDTO.getSeatsFilled());
        events.setCriteria(eventsDTO.getCriteria());
        return events;
    }

}
