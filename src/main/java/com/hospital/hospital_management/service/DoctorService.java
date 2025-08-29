package com.hospital.hospital_management.service;

import com.hospital.hospital_management.dto.DoctorDTO;
import com.hospital.hospital_management.model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor create(DoctorDTO dto);
    Doctor getById(String id);
    List<Doctor> listAll();
    List<Doctor> listActive();
    List<Doctor> searchBySpecialization(String specialization);
    Doctor update(String id, DoctorDTO dto);
    void delete(String id);
}
