package com.hospital.hospital_management.controller;

import com.hospital.hospital_management.dto.BillDTO;
import com.hospital.hospital_management.model.Bill;
import com.hospital.hospital_management.service.BillingService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/billing")
@Validated
public class BillingController {

    private final BillingService service;

    public BillingController(BillingService service) {
        this.service = service;
    }

    @PostMapping
    public Bill create(@Valid @RequestBody BillDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<Bill> listAll(@RequestParam(value = "patientId", required = false) String patientId,
                                 @RequestParam(value = "status", required = false) String status) {
        if (patientId != null) return service.listByPatient(patientId);
        if (status != null) return service.listByStatus(status);
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Bill get(@PathVariable String id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Bill update(@PathVariable String id, @Valid @RequestBody BillDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/window")
    public List<Bill> listByWindow(@RequestParam("from") String fromIso,
                                      @RequestParam("to") String toIso) {
        LocalDateTime from = LocalDateTime.parse(fromIso);
        LocalDateTime to = LocalDateTime.parse(toIso);
        return service.listByInvoiceWindow(from, to);
    }
}
