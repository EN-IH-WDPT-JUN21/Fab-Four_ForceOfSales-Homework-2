package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.LeadList;
import com.ironhack.FabFour.homework2.model.Opportunity;

import java.util.Scanner;

public class CommandHandler {
    public static void main(String[] args) {

    }

    public void handleCommand(String command) {}

    public Lead createLead() {
        LeadList tester = new LeadList(); // created as a dummy whilst working out how to add objects to list
        String tempName; String tempNumber;
        String tempEmail; String tempCompany;
        Lead tempLead = null;
        Scanner aScanner = new Scanner(System.in);
            System.out.println("Please enter their contact name.");
            tempName = aScanner.next();
            System.out.println("Please enter their phone number.");
            tempNumber = aScanner.next();
            System.out.println("Please enter their email address.");
            tempEmail = aScanner.next();
            System.out.println("Please enter their company's name");
            tempCompany = aScanner.next();
            tempLead = new Lead(tempName,tempNumber,tempEmail,tempCompany);
            LeadList.getListOfLeads().add(tempLead);
            System.out.println("Lead created. Lead ID: " + tempLead.getId());
            return tempLead;
    }

    public Lead lookupLead(long id) {
        Lead foundLead = null;
        for (Lead aLead : LeadList.getListOfLeads()) {
            if (aLead.getId() == id) {
                foundLead = aLead;
                break;
            }
        }
        return foundLead;
    }

    public void removeLead(long id) {
        for (Lead aLead : LeadList.getListOfLeads()) {
            if (aLead.getId() == id) {
                LeadList.getListOfLeads().remove(aLead);
                break;
            }
        }
    }

    public Opportunity convertLead(long id) { return null;}
    public void updateOpportunityStatus(long id) {}
    public void IOHandler(){}
}
