package com.hospital.hospital_management.repository;

import com.hospital.hospital_management.model.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BillRepository extends MongoRepository<Bill, String> {
    List<Bill> findByPatientId(String patientId);
    List<Bill> findByStatus(String status);
    List<Bill> findByInvoiceDateBetween(LocalDateTime from, LocalDateTime to);
}
