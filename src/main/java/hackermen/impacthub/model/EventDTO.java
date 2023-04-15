package hackermen.impacthub.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;


public class EventDTO {

    private UUID eventID;

    @NotNull
    @Size(max = 255)
    private String eventName;

    @Size(max = 255)
    private String description;

    @NotNull
    private LocalDate deadline;

    @NotNull
    @Size(max = 255)
    private String location;

    private Integer capacity;

    @Size(max = 255)
    private String employeeList;

    public UUID getEventID() {
        return eventID;
    }

    public void setEventID(final UUID eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(final String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(final LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(final Integer capacity) {
        this.capacity = capacity;
    }

    public String getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(final String employeeList) {
        this.employeeList = employeeList;
    }

}
