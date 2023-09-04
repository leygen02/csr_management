package io.impacthub.impacthub.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class EmployeesDTO {

    private Integer id;

    @NotNull
    @Size(max = 255)
    private String firstname;

    @NotNull
    @Size(max = 255)
    private String lastname;

    @NotNull
    @Size(max = 255)
    private String email;

    private Integer event;

    @NotNull
    private Integer organiser;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Integer getEvent() {
        return event;
    }

    public void setEvent(final Integer event) {
        this.event = event;
    }

    public Integer getOrganiser() {
        return organiser;
    }

    public void setOrganiser(final Integer organiser) {
        this.organiser = organiser;
    }

}
