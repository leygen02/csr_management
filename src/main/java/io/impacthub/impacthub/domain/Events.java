package io.impacthub.impacthub.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
public class Events {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Boolean visibility;

    @Column
    private Integer seatsFilled;

    @Column
    private String criteria;

    @OneToMany(mappedBy = "event")
    private Set<Employees> employeelist;

    @OneToOne(mappedBy = "organiser", fetch = FetchType.LAZY)
    private Employees orgemployee;

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

    public Set<Employees> getEmployeelist() {
        return employeelist;
    }

    public void setEmployeelist(final Set<Employees> employeelist) {
        this.employeelist = employeelist;
    }

    public Employees getOrgemployee() {
        return orgemployee;
    }

    public void setOrgemployee(final Employees orgemployee) {
        this.orgemployee = orgemployee;
    }

}
