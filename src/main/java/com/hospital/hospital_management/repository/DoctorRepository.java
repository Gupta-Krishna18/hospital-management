package com.hospital.hospital_management.repository;

import com.hospital.hospital_management.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    List<Doctor> findBySpecializationIgnoreCase(String specialization);
    List<Doctor> findByDepartmentIgnoreCase(String department);
    List<Doctor> findByActiveTrue();
}
