package com.hospital.hospital_management.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BillDTO {

    @NotBlank
    private String patientId;

    private String appointmentId;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal amount;

    @NotBlank
    private String currency;        // e.g., "INR"

    @NotBlank
    private String status;          // PAID, UNPAID, PARTIALLY_PAID

    @NotNull
    private LocalDateTime invoiceDate;

    private String paymentMethod;   // CASH, CARD, UPI
    private String notes;

    public BillDTO() {}

    public BillDTO(String patientId, String appointmentId, BigDecimal amount, String currency,
                      String status, LocalDateTime invoiceDate, String paymentMethod, String notes) {
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
