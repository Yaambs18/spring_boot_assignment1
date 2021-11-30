package com.java.spring_boot_assignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    private final int empId;
    private final String jobTitle;
    private final String firstName;
    private final String lastName;
    private final long phoneNumber;
    private final String emailAddress;

    public Employee(@JsonProperty("id") int empId,
                    @JsonProperty("jobTitleName") String jobTitle, @JsonProperty("firstname") String firstName,
                    @JsonProperty("lastname") String lastName, @JsonProperty("phonenumber") long phoneNumber,
                    @JsonProperty("emailid") String emailAddress) {
        this.empId = empId;
        this.jobTitle = jobTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public int getEmpId() {
        return empId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
