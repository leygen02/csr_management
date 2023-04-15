package hackermen.impacthub.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;


public class EmployeeDTO {

    private UUID employeeID;

    @NotNull
    @Size(max = 255)
    private String firstName;

    @NotNull
    @Size(max = 255)
    private String lastName;

    private Integer attendanceRate;

    private Boolean prevEnrolled;

    @NotNull
    @Size(max = 255)
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
