package com.hospital.hospital_management.controller;

import com.hospital.hospital_management.dto.AppointmentDTO;
import com.hospital.hospital_management.model.Appointment;
import com.hospital.hospital_management.service.AppointmentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@Validated
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping
    public Appointment create(@Valid @RequestBody AppointmentDTO dto) {
        return service.create(dto);
    }


    @GetMapping
    public List<Appointment> listAll(@RequestParam(value = "doctorId", required = false) String doctorId,
                                     @RequestParam(value = "patientId", required = false) String patientId) {
        if (doctorId != null) return service.listByDoctor(doctorId);
        if (patientId != null) return service.listByPatient(patientId);
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Appointment get(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Appointment update(@PathVariable String id, @Valid @RequestBody AppointmentDTO dto) {
        return service.update(id, dto);
    }

    @PostMapping("/{id}/cancel")
    public void cancel(@PathVariable String id) {
        service.cancel(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/doctor/{doctorId}/window")
    public List<Appointment> listDoctorWindow(@PathVariable String doctorId,
                                              @RequestParam("from") String fromIso,
                                              @RequestParam("to") String toIso) {
        LocalDateTime from = LocalDateTime.parse(fromIso);
        LocalDateTime to = LocalDateTime.parse(toIso);
        return service.listDoctorAppointmentsInWindow(doctorId, from, to);
    }
}
