package com.ironhack.FabFour.homework2.common;

import java.util.List;

public class LeadList {

    private static List<Lead> listOfLeads;

    public void showLeads() {
        for (Lead lead : listOfLeads) {
            System.out.println("Lead ID: " + lead.getId() + ", Contact Name: " + lead.getContactName() + ". /n");
        }
    }
}
