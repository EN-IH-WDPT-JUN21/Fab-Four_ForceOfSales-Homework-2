package com.ironhack.FabFour.homework2.model;

public class Contact extends Lead {

    private static long contactIDCount = 5000;

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
