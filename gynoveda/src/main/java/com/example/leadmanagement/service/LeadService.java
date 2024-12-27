package com.example.leadmanagement.service;

import com.example.leadmanagement.model.Lead;
import com.example.leadmanagement.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {
    @Autowired
    private LeadRepository leadRepository;

    public Lead createLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public Optional<Lead> getLeadById(Long id) {
        return leadRepository.findById(id);
    }

    public Lead updateLeadStatus(Long id, Lead.Status status, String reason) {
        Lead lead = leadRepository.findById(id).orElseThrow();
        lead.setStatus(status);
        lead.setReason(reason);
        return leadRepository.save(lead);
    }
}