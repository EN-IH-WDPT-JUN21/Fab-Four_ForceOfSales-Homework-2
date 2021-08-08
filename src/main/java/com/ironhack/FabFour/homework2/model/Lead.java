package com.ironhack.FabFour.homework2.model;

import java.util.Scanner;

import static com.ironhack.FabFour.homework2.common.CommandHandler.colorMessage;
import static com.ironhack.FabFour.homework2.common.DataValidator.*;

public class Lead {

    public static final String RED_TEXT = "\033[31m";

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
        Scanner aScanner = new Scanner(System.in);
        String input = this.contactName = name;;
        while (input.isEmpty() || !containsOnlyLetters(input)) {
            colorMessage("Please provide a valid contact name.", RED_TEXT);
            input = aScanner.nextLine();
        }
        this.contactName = input;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        // Verifies that input is not empty, and is also a valid phone number
        Scanner aScanner = new Scanner(System.in);
        String input = phoneNumber;
        while (!validatePhoneNumber(input)) {
            colorMessage("Please provide a valid phone number. It must be between 6 and 15 digits, and can have hyphens or +. Spaces are not allowed.", RED_TEXT);
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
            colorMessage("Please provide a valid email.", RED_TEXT);
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
            colorMessage("Please provide a valid company name.", RED_TEXT);
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
        return "Lead: " + this.getId() + ", Contact: " + this.getContactName() + ", Phone Number: " +
                this.getPhoneNumber() + ", Email: " + this.getEmail() + ", Company Name: " + this.getCompanyName();
    }
}
