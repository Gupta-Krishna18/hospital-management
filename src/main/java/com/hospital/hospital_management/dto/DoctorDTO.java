package com.hospital.hospital_management.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DoctorDTO {

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank
    private String specialization;

    private String department;
    @Email
    private String email;

    private String phoneNumber;
    private boolean active = true;

    public DoctorDTO() {}

    public DoctorDTO(String name, String specialization, String department,
                     String email, String phoneNumber, boolean active) {
        this.name = name;
        this.specialization = specialization;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.active = active;
    }

    // Getters & Setters
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
