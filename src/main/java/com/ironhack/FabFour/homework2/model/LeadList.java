package com.ironhack.FabFour.homework2.model;

import java.util.ArrayList;
import java.util.List;

public class LeadList {

    private static List<Lead> listOfLeads = new ArrayList<>();

    public static List<Lead> getListOfLeads() {
        return listOfLeads;
    }

    public static int countLeads() {
        return listOfLeads.size();
    }

    public static void showLeads() {

        if(listOfLeads.size()>0) {
            for (Lead lead : listOfLeads) {
                System.out.println("Lead ID: " + lead.getId() + ", Contact Name: " + lead.getContactName() + ".\n");
            }
        } else System.out.println("There is no leads! Try to add some by 'new lead' command");
    }
}
