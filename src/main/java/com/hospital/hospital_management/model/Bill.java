package com.hospital.hospital_management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "bill")
public class Bill {

    @Id
    private String id;

    private String patientId;
    private String appointmentId;       // link to appointment (optional)
    private BigDecimal amount;
    private String currency;            // extra field (e.g., INR, USD)
    private String status;              // PAID, UNPAID, PARTIALLY_PAID
    private LocalDateTime invoiceDate;
    private String paymentMethod;       // extra field (e.g., CASH, CARD, UPI)
    private String notes;               // extra field

    public Bill() {}

    public Bill(String id, String patientId, String appointmentId, BigDecimal amount, String currency,
                   String status, LocalDateTime invoiceDate, String paymentMethod, String notes) {
        this.id = id;
        this.patientId = patientId;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.invoiceDate = invoiceDate;
        this.paymentMethod = paymentMethod;
        this.notes = notes;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(LocalDateTime invoiceDate) { this.invoiceDate = invoiceDate; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
