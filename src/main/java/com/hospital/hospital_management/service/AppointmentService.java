package com.hospital.hospital_management.service;

import com.hospital.hospital_management.dto.AppointmentDTO;
import com.hospital.hospital_management.model.Appointment;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    Appointment create(AppointmentDTO dto);
    Appointment getById(String id);
    List<Appointment> listAll();
    List<Appointment> listByDoctor(String doctorId);
    List<Appointment> listByPatient(String patientId);
    List<Appointment> listDoctorAppointmentsInWindow(String doctorId, LocalDateTime from, LocalDateTime to);
    Appointment update(String id, AppointmentDTO dto);
    void cancel(String id);
    void delete(String id);
}
