package com.ironhack.FabFour.homework2.model;

import java.util.Scanner;

import static com.ironhack.FabFour.homework2.common.DataValidator.validateEmail;
import static com.ironhack.FabFour.homework2.common.DataValidator.validatePhoneNumber;

public class Lead {

    // Value for the lead ID, automatically incremented on each creation
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

    // Sets id to current leadIDCount, then increments leadIDCount
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
        // Verifies that input is not empty, and is also a valid phone number
        Scanner aScanner = new Scanner(System.in);
        String input = phoneNumber;
        while (!validatePhoneNumber(input)) {
            System.out.println("Please provide a valid phone number. It must be between 6 and 15 digits, and can have spaces, hyphens or +.");
            input = aScanner.next();
        }
        this.phoneNumber = input;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // Verifies that input is not empty, and is also a valid email
        Scanner aScanner = new Scanner(System.in);
        String input = email;
        while (!validateEmail(input)) {
            System.out.println("Please provide a valid email.");
            input = aScanner.next();
        }
        this.email = input;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        // Verifies that input is not empty
        Scanner aScanner = new Scanner(System.in);
        String input = companyName;
        while (input.isEmpty()) {
            System.out.println("Please provide a valid company name.");
            input = aScanner.nextLine();
        }
        this.companyName = input;
    }

    // Checks that leads are not duplicated on each attribute except ID. As the ID is auto-incremented, it is assumed
    // that they will not be repeated.
    @Override
    public boolean equals(Object l) {
        if (this == l) return true;
        if (l == null || getClass() != l.getClass()) return false;
        Lead that = (Lead) l;
        return this.getCompanyName() == that.getCompanyName() &&
                this.getEmail() == that.getEmail() && this.getContactName() == that.getContactName() &&
                this.getPhoneNumber() == that.getPhoneNumber();
    }

    @Override
    public String toString() {
        return "Lead: " + this.getId() + ", Name of Contact: " + this.getContactName() + ", Phone Number: " +
                this.getPhoneNumber() + ", Email: " + this.getEmail() + ", Company Name: " + this.getCompanyName();
    }
}
