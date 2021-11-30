package com.java.spring_boot_assignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Department {
    private int deptId;
    final private String name;
    final private String phoneNumber;
    final private String email;

    public Department(@JsonProperty("deptId") int deptId, @JsonProperty("name") String name
    ,@JsonProperty("phoneNumber") String phoneNumber,@JsonProperty("email") String email){
        this.deptId=deptId;
        this.email=email;
        this.name=name;
        this.phoneNumber=phoneNumber.replace("-","");
    }

    public int getDeptId() {
        return deptId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

}
