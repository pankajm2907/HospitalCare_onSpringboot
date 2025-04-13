package com.pms.patient_service.feign;

import com.pms.patient_service.dto.BillingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "billing-service")
public interface BillingClient {
    @GetMapping("/api/billings/patient/{patientId}")
    List<BillingDTO> getBillsByPatientId(@PathVariable Long patientId);
}
