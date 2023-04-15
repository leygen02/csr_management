package hackermen.impacthub.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Employee {

    @Id
    @Column(nullable = false, updatable = false, columnDefinition = "char(36)")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    private UUID employeeID;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private Integer attendanceRate;

    @Column
    private Boolean prevEnrolled;

    @Column(nullable = false)
    private String emailID;

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(final UUID employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Integer getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(final Integer attendanceRate) {
        this.attendanceRate = attendanceRate;
    }

    public Boolean getPrevEnrolled() {
        return prevEnrolled;
    }

    public void setPrevEnrolled(final Boolean prevEnrolled) {
        this.prevEnrolled = prevEnrolled;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(final String emailID) {
        this.emailID = emailID;
    }

}
