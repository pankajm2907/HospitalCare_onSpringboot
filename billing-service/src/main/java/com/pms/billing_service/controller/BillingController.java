package com.pms.billing_service.controller;

import com.pms.billing_service.entity.Billing;
import com.pms.billing_service.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    @Autowired
    private BillingRepository billingRepository;

    @GetMapping
    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }

    @PostMapping
    public Billing createBill(@RequestBody Billing billing) {
        return billingRepository.save(billing);
    }

    @GetMapping("/{id}")
    public Billing getBillById(@PathVariable Long id) {
        return billingRepository.findById(id).orElse(null);
    }

    @GetMapping("/patient/{patientId}")
    public List<Billing> getBillsByPatientId(@PathVariable Long patientId) {
        return billingRepository.findAll().stream()
                .filter(bill -> patientId.equals(bill.getPatientId()))
                .toList();
    }
    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable Long id) {
        if (!billingRepository.existsById(id)) {
            return "Bill with ID " + id + " not found.";
        }

        billingRepository.deleteById(id);
        return "Bill with ID " + id + " deleted.";
    }




}
