package com.ironhack.FabFour.homework2.model;

import java.util.ArrayList;
import java.util.List;

public class LeadList {

    private static List<Lead> listOfLeads = new ArrayList<>();

    public static List<Lead> getListOfLeads() {
        return listOfLeads;
    }

    public static void setListOfLeads(List<Lead> listOfLeads) {
        LeadList.listOfLeads = listOfLeads;
    }

    public int countLeads() {
        return listOfLeads.size();
    }

    public static void showLeads() {
        for (Lead lead : listOfLeads) {
            System.out.println("Lead ID: " + lead.getId() + ", Contact Name: " + lead.getContactName() + ". /n");
        }
    }
}
