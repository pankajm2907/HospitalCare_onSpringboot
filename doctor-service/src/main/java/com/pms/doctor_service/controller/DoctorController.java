package com.pms.doctor_service.controller;

import com.pms.doctor_service.entity.Doctor;
import com.pms.doctor_service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        if (!doctorRepository.existsById(id)) {
            return "Doctor with ID " + id + " not found.";
        }

        doctorRepository.deleteById(id);
        return "Doctor with ID " + id + " deleted.";
    }


}
