package com.hospital.hospital_management.service.impl;

import com.hospital.hospital_management.dto.BillDTO;
import com.hospital.hospital_management.model.Bill;
import com.hospital.hospital_management.repository.BillRepository;
import com.hospital.hospital_management.service.BillingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Service
public class BillingServiceImpl implements BillingService {

    private final BillRepository repo;

    public BillingServiceImpl(BillRepository repo) {
        this.repo = repo;
    }

    @Override
    public Bill create(BillDTO dto) {
        Bill b = new Bill();
        b.setPatientId(dto.getPatientId());
        b.setAppointmentId(dto.getAppointmentId());
        b.setAmount(dto.getAmount());
        b.setCurrency(dto.getCurrency());
        b.setStatus(dto.getStatus());
        b.setInvoiceDate(dto.getInvoiceDate());
        b.setPaymentMethod(dto.getPaymentMethod());
        b.setNotes(dto.getNotes());
        return repo.save(b);
    }

    @Override
    public Bill getById(String id) {
        Optional<Bill> opt = repo.findById(id);
        return opt.orElse(null);
    }

    @Override
    public List<Bill> listAll() {
        return repo.findAll();
    }

    @Override
    public List<Bill> listByPatient(String patientId) {
        return repo.findByPatientId(patientId);
    }

    @Override
    public List<Bill> listByStatus(String status) {
        return repo.findByStatus(status);
    }

    @Override
    public List<Bill> listByInvoiceWindow(LocalDateTime from, LocalDateTime to) {
        return repo.findByInvoiceDateBetween(from, to);
    }

    @Override
    public Bill update(String id, BillDTO dto) {
        Optional<Bill> opt = repo.findById(id);
        if (!opt.isPresent()) return null;

        Bill b = opt.get();
        b.setPatientId(dto.getPatientId());
        b.setAppointmentId(dto.getAppointmentId());
        b.setAmount(dto.getAmount());
        b.setCurrency(dto.getCurrency());
        b.setStatus(dto.getStatus());
        b.setInvoiceDate(dto.getInvoiceDate());
        b.setPaymentMethod(dto.getPaymentMethod());
        b.setNotes(dto.getNotes());
        return repo.save(b);
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }
}
