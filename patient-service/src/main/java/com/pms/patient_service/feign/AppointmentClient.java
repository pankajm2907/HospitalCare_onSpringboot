package com.pms.patient_service.feign;

import com.pms.patient_service.dto.AppointmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "appointment-service")
public interface AppointmentClient {
    @GetMapping("/api/appointments/patient/{patientId}")
    List<AppointmentDTO> getAppointmentsByPatientId(@PathVariable Long patientId);
}
