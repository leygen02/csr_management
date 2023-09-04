package io.impacthub.impacthub.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;


public class EventsDTO {

    private Integer id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String location;

    private String description;

    @NotNull
    private Integer capacity;

    @NotNull
    private LocalDateTime date;

    @NotNull
    private Boolean visibility;

    private Integer seatsFilled;

    @Size(max = 255)
    private String criteria;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(final Integer capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(final LocalDateTime date) {
        this.date = date;
    }

    public Boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(final Boolean visibility) {
        this.visibility = visibility;
    }

    public Integer getSeatsFilled() {
        return seatsFilled;
    }

    public void setSeatsFilled(final Integer seatsFilled) {
        this.seatsFilled = seatsFilled;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(final String criteria) {
        this.criteria = criteria;
    }

}
