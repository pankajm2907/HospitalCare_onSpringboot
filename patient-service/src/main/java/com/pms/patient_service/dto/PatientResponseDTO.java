package com.pms.patient_service.dto;

import java.io.Serializable;
import java.util.List;

public class PatientResponseDTO implements Serializable {
    private Long id;
    private String name;
    private String gender;
    private String email;
    private String phone;

    private List<AppointmentDTO> appointments;
    private List<BillingDTO> bills;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public List<AppointmentDTO> getAppointments() { return appointments; }
    public void setAppointments(List<AppointmentDTO> appointments) { this.appointments = appointments; }

    public List<BillingDTO> getBills() { return bills; }
    public void setBills(List<BillingDTO> bills) { this.bills = bills; }
}
