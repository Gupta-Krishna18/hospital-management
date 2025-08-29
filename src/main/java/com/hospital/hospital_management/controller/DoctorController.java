package com.hospital.hospital_management.controller;

import com.hospital.hospital_management.dto.DoctorDTO;
import com.hospital.hospital_management.model.Doctor;
import com.hospital.hospital_management.service.DoctorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@Validated
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public Doctor create(@Valid @RequestBody DoctorDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<Doctor> listAll(@RequestParam(value = "specialization", required = false) String specialization,
                                @RequestParam(value = "activeOnly", required = false, defaultValue = "false") boolean activeOnly) {
        if (specialization != null && !specialization.isEmpty()) {
            return service.searchBySpecialization(specialization);
        }
        if (activeOnly) return service.listActive();
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Doctor get(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Doctor update(@PathVariable String id, @Valid @RequestBody DoctorDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
