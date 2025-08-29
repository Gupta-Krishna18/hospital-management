package com.hospital.hospital_management.service.impl;



import com.hospital.hospital_management.dto.PatientDTO;
import com.hospital.hospital_management.model.Patient;
import com.hospital.hospital_management.repository.PatientRepository;
import com.hospital.hospital_management.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setAge(patientDTO.getAge());
        patient.setGender(patientDTO.getGender());
        patient.setContactNumber(patientDTO.getContactNumber());
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(String id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }

    @Override
    public Patient updatePatient(String id, PatientDTO patientDTO) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setName(patientDTO.getName());
            patient.setAge(patientDTO.getAge());
            patient.setGender(patientDTO.getGender());
            patient.setContactNumber(patientDTO.getContactNumber());
            return patientRepository.save(patient);
        }
        return null;
    }

    @Override
    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}

