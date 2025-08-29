package com.hospital.hospital_management.service;


import com.hospital.hospital_management.dto.PatientDTO;
import com.hospital.hospital_management.model.Patient;

import java.util.List;

public interface PatientService {
    Patient createPatient(PatientDTO patientDTO);
    List<Patient> getAllPatients();
    Patient getPatientById(String id);
    Patient updatePatient(String id, PatientDTO patientDTO);
    void deletePatient(String id);
}