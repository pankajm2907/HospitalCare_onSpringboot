package com.pms.appointment_service.controller;

import com.pms.appointment_service.entity.Appointment;
import com.pms.appointment_service.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Long patientId) {
        return appointmentRepository.findAll().stream()
                .filter(a -> a.getPatientId().equals(patientId))
                .toList();
    }
    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        if (!appointmentRepository.existsById(id)) {
            return "Appointment with ID " + id + " not found.";
        }

        appointmentRepository.deleteById(id);
        return "Appointment with ID " + id + " deleted.";
    }

}
