package hackermen.impacthub.rest;

import hackermen.impacthub.model.EventDTO;
import hackermen.impacthub.service.EventService;
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
@RequestMapping(value = "/api/events", produces = MediaType.APPLICATION_JSON_VALUE)
public class EventResource {

    private final EventService eventService;

    public EventResource(final EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return ResponseEntity.ok(eventService.findAll());
    }

    @GetMapping("/{eventID}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable(name = "eventID") final UUID eventID) {
        return ResponseEntity.ok(eventService.get(eventID));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<UUID> createEvent(@RequestBody @Valid final EventDTO eventDTO) {
        return new ResponseEntity<>(eventService.create(eventDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{eventID}")
    public ResponseEntity<Void> updateEvent(@PathVariable(name = "eventID") final UUID eventID,
            @RequestBody @Valid final EventDTO eventDTO) {
        eventService.update(eventID, eventDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{eventID}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteEvent(@PathVariable(name = "eventID") final UUID eventID) {
        eventService.delete(eventID);
        return ResponseEntity.noContent().build();
    }

}
