package com.example.leadmanagement.dto;

public class LeadDTO {
    private String name;
    private String phoneNumber;

    // Constructors, Getters, and Setters
    public LeadDTO() {}
    public LeadDTO(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}