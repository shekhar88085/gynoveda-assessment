package com.example.leadmanagement.scheduler;

import com.example.leadmanagement.model.Lead;
import com.example.leadmanagement.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CallScheduler {

    @Autowired
    private LeadRepository leadRepository;

    @Scheduled(fixedRate = 60000) // Every 1 minute
    public void pollPendingLeads() {
        List<Lead> pendingLeads = leadRepository.findAll()
                .stream()
                .filter(lead -> lead.getStatus() == Lead.Status.PENDING)
                .toList();

        for (Lead lead : pendingLeads) {
            System.out.println("Mock call to " + lead.getPhoneNumber());
            // Logic to handle mock API call
        }
    }
}