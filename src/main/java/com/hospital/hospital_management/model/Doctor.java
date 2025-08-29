package com.hospital.hospital_management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctors")
public class Doctor {

    @Id
    private String id;

    private String name;
    private String specialization;
    private String department;     // extra field
    private String email;          // extra field
    private String phoneNumber;    // extra field
    private boolean active;

    public Doctor() {}

    public Doctor(String id, String name, String specialization, String department,
                  String email, String phoneNumber, boolean active) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.active = active;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
