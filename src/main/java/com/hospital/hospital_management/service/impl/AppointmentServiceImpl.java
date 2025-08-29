package com.hospital.hospital_management.service.impl;

import com.hospital.hospital_management.dto.AppointmentDTO;
import com.hospital.hospital_management.model.Appointment;
import com.hospital.hospital_management.repository.AppointmentRepository;
import com.hospital.hospital_management.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repo;

    public AppointmentServiceImpl(AppointmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Appointment create(AppointmentDTO dto) {
        // Simple guard: end after start
        if (dto.getEndTime().isBefore(dto.getStartTime())) {
            throw new IllegalArgumentException("End time cannot be before start time.");
        }
        Appointment a = new Appointment();
        a.setPatientId(dto.getPatientId());
        a.setDoctorId(dto.getDoctorId());
        a.setStartTime(dto.getStartTime());
        a.setEndTime(dto.getEndTime());
        a.setStatus(dto.getStatus());
        a.setReason(dto.getReason());
        a.setLocation(dto.getLocation());
        a.setNotes(dto.getNotes());
        return repo.save(a);
    }

    @Override
    public Appointment getById(String id) {
        Optional<Appointment> opt = repo.findById(id);
        return opt.orElse(null);
    }

    @Override
    public List<Appointment> listAll() {
        return repo.findAll();
    }

    @Override
    public List<Appointment> listByDoctor(String doctorId) {
        return repo.findByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> listByPatient(String patientId) {
        return repo.findByPatientId(patientId);
    }

    @Override
    public List<Appointment> listDoctorAppointmentsInWindow(String doctorId, LocalDateTime from, LocalDateTime to) {
        return repo.findByDoctorIdAndStartTimeBetween(doctorId, from, to);
    }

    @Override
    public Appointment update(String id, AppointmentDTO dto) {
        Optional<Appointment> opt = repo.findById(id);
        if (!opt.isPresent()) return null;

        Appointment a = opt.get();
        a.setPatientId(dto.getPatientId());
        a.setDoctorId(dto.getDoctorId());
        a.setStartTime(dto.getStartTime());
        a.setEndTime(dto.getEndTime());
        a.setStatus(dto.getStatus());
        a.setReason(dto.getReason());
        a.setLocation(dto.getLocation());
        a.setNotes(dto.getNotes());
        return repo.save(a);
    }

    @Override
    public void cancel(String id) {
        Optional<Appointment> opt = repo.findById(id);
        if (opt.isPresent()) {
            Appointment a = opt.get();
            a.setStatus("CANCELLED");
            repo.save(a);
        }
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }
}
