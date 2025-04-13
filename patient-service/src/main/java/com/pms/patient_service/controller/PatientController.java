package com.pms.patient_service.controller;

import com.pms.patient_service.dto.AppointmentDTO;
import com.pms.patient_service.dto.BillingDTO;
import com.pms.patient_service.dto.PatientResponseDTO;
import com.pms.patient_service.entity.Patient;
import com.pms.patient_service.repository.PatientRepository;
import com.pms.patient_service.feign.AppointmentClient;
import com.pms.patient_service.feign.BillingClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentClient appointmentClient;

    @Autowired
    private BillingClient billingClient;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }


    @GetMapping("/cache/{id}")
    @Cacheable(value = "patients", key = "#id")
    public PatientResponseDTO getPatientById(@PathVariable Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) return null;

        List<AppointmentDTO> appointments = appointmentClient.getAppointmentsByPatientId(id);
        List<BillingDTO> bills = billingClient.getBillsByPatientId(id);

        PatientResponseDTO response = new PatientResponseDTO();
        response.setId(patient.getId());
        response.setName(patient.getName());
        response.setGender(patient.getGender());
        response.setAppointments(appointments);
        response.setBills(bills);

        return response;
    }
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        if (!patientRepository.existsById(id)) {
            return "Patient with ID " + id + " does not exist.";
        }

        patientRepository.deleteById(id);
        return "Patient with ID " + id + " has been deleted successfully.";
    }

}
