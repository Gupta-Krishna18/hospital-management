package com.hospital.hospital_management.service;

import com.hospital.hospital_management.dto.BillDTO;
import com.hospital.hospital_management.model.Bill;

import java.time.LocalDateTime;
import java.util.List;

public interface BillingService {
    Bill create(BillDTO dto);
    Bill getById(String id);
    List<Bill> listAll();
    List<Bill> listByPatient(String patientId);
    List<Bill> listByStatus(String status);
    List<Bill> listByInvoiceWindow(LocalDateTime from, LocalDateTime to);
    Bill update(String id, BillDTO dto);
    void delete(String id);
}
