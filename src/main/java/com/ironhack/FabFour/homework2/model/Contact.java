package com.ironhack.FabFour.homework2.model;

public class Contact extends Lead {

    // Value for the contact ID, automatically incremented on each creation
    private static long contactIDCount = 5000;

    // Constructor calls the Lead constructor, uses all the same validators
    public Contact(String contactName, String phoneNumber, String email, String companyName) {
        super(contactName, phoneNumber, email, companyName);
    }

    public static long getContactIDCount() {
        return contactIDCount;
    }

    @Override
    public void setId() {
        this.id = contactIDCount;
        contactIDCount++;
    }
}
