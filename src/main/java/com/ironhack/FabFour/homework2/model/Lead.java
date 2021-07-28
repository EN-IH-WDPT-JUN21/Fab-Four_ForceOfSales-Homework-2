package com.ironhack.FabFour.homework2.model;

import java.util.Scanner;

public class Lead {
    private static int leadIDCount = 1;
    protected long id;
    private String contactName;
    private String phoneNumber;
    private String email;
    private String companyName;

    public Lead(String contactName, String phoneNumber, String email, String companyName) {
        setId();
        setContactName(contactName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    public static int getLeadIDCount() {
        return Lead.leadIDCount;
    }

    public long getId() {
        return this.id;
    }

    public void setId() {
        this.id = leadIDCount;
        leadIDCount++;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String name) {
        if (!name.isBlank()) {
            this.contactName = name;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.isBlank()) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.isBlank() && email.contains("@")) {
            this.email = email;
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        if (!companyName.isBlank()) {
            this.companyName = companyName;
        }
    }

    @Override
    public boolean equals(Object l) {
        if (this == l) return true;
        if (l == null || getClass() != l.getClass()) return false;
        Lead that = (Lead) l;
        return getCompanyName() == that.getCompanyName() &&
                getEmail() == that.getEmail() && getContactName() == that.getContactName() &&
                getPhoneNumber() == that.getPhoneNumber();
    }

    @Override
    public String toString() {
        return "Lead: " + this.getId() + ", Name of Contact: " + this.getContactName() + ", Phone Number: " +
                this.getPhoneNumber() + ", Email: " + this.getEmail() + ", Company Name: " + this.getCompanyName();
    }
}
