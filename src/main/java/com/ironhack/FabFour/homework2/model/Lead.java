package com.ironhack.FabFour.homework2.model;

import java.util.Scanner;

public class Lead {
    private static int leadIDCount = 1;
    private long id;
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
        else {
            Scanner aScanner = new Scanner(System.in);
            System.out.println("Please provide a name");
            if (aScanner.hasNextLine()) {
                setContactName(aScanner.next());
            }
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.isBlank()) {
            this.phoneNumber = phoneNumber;
        }
        else {
            Scanner aScanner = new Scanner(System.in);
            System.out.println("There was no phone number provided. Would you like to provide one? y/n");
            if (aScanner.next().equals("y")) {
                System.out.println("Please provide a phone number.");
                setPhoneNumber(aScanner.next());
            }
            else {
                this.phoneNumber = "";
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.isBlank() && email.contains("@")) {
            this.email = email;
        }
        else {
            Scanner aScanner = new Scanner(System.in);
            System.out.println("A valid email was not provided. Would you like to provide one? y/n");
            if (aScanner.next().equals("y")) {
                System.out.println("Please provide a valid email. Valid email address must have an '@'");
                setEmail(aScanner.next());
            }
            else {
                this.email = "";
            }
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
    public String toString() {
        return "Lead: " + this.getId() + ", Name of Contact: " + this.getContactName() + ", Phone Number: " +
                this.getPhoneNumber() + ", Email: " + this.getEmail() + ", Company Name: " + this.getCompanyName();
    }
}
