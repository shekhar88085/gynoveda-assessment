package com.example.leadmanagement.controller;

import com.example.leadmanagement.dto.LeadDTO;
import com.example.leadmanagement.model.Lead;
import com.example.leadmanagement.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    public Lead createLead(@RequestBody LeadDTO leadDTO) {
        Lead lead = new Lead();
        lead.setName(leadDTO.getName());
        lead.setPhoneNumber(leadDTO.getPhoneNumber());
        return leadService.createLead(lead);
    }

    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @GetMapping("/{id}")
    public Lead getLeadById(@PathVariable Long id) {
        return leadService.getLeadById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Lead updateLeadStatus(
        @PathVariable Long id,
        @RequestParam Lead.Status status,
        @RequestParam(required = false) String reason
    ) {
        return leadService.updateLeadStatus(id, status, reason);
    }
}