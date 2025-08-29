package com.hospital.hospital_management.service.impl;

import com.hospital.hospital_management.dto.DoctorDTO;
import com.hospital.hospital_management.model.Doctor;
import com.hospital.hospital_management.repository.DoctorRepository;
import com.hospital.hospital_management.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repo;

    public DoctorServiceImpl(DoctorRepository repo) {
        this.repo = repo;
    }

    @Override
    public Doctor create(DoctorDTO dto) {
        Doctor d = new Doctor();
        d.setName(dto.getName());
        d.setSpecialization(dto.getSpecialization());
        d.setDepartment(dto.getDepartment());
        d.setEmail(dto.getEmail());
        d.setPhoneNumber(dto.getPhoneNumber());
        d.setActive(dto.isActive());
        return repo.save(d);
    }

    @Override
    public Doctor getById(String id) {
        Optional<Doctor> opt = repo.findById(id);
        return opt.orElse(null);
    }

    @Override
    public List<Doctor> listAll() {
        return repo.findAll();
    }

    @Override
    public List<Doctor> listActive() {
        return repo.findByActiveTrue();
    }

    @Override
    public List<Doctor> searchBySpecialization(String specialization) {
        return repo.findBySpecializationIgnoreCase(specialization);
    }

    @Override
    public Doctor update(String id, DoctorDTO dto) {
        Optional<Doctor> opt = repo.findById(id);
        if (!opt.isPresent()) return null;

        Doctor d = opt.get();
        d.setName(dto.getName());
        d.setSpecialization(dto.getSpecialization());
        d.setDepartment(dto.getDepartment());
        d.setEmail(dto.getEmail());
        d.setPhoneNumber(dto.getPhoneNumber());
        d.setActive(dto.isActive());
        return repo.save(d);
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }
}
