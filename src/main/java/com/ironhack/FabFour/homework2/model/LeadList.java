package com.ironhack.FabFour.homework2.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

// LeadList is a storage class for all the leads created in the process of running the program. Every time createLead()
// is called and a valid lead is created, that lead is added to this list.

public class LeadList {

    private static List<Lead> listOfLeads = new ArrayList<>();

    public static List<Lead> getListOfLeads() {
        return listOfLeads;
    }

    public static int countLeads() {
        return listOfLeads.size();
    }

    // Shows attribute information for each lead currently in LeadList. Returns an error if no leads exists.
    public static void showLeads() {

        if(listOfLeads.size()>0) {
            for (Lead lead : listOfLeads) {
                System.out.println("Lead ID: " + lead.getId() + ", Contact Name: " + lead.getContactName() + ".\n");
            }
        } else System.out.println("There are no leads! Try to add some with the 'new lead' command");
    }
}
