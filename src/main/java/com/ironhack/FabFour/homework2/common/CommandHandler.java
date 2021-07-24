package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Industry;
import com.ironhack.FabFour.homework2.enums.Product;
import com.ironhack.FabFour.homework2.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Scanner;

public class CommandHandler {

    public Account convertLead(long id) {
        //lookup Lead with id = id
        Lead leadToConvert = lookupLead(id);
        //extract Lead info
        String contactName = leadToConvert.getContactName();
        String contactPhoneNumber = leadToConvert.getPhoneNumber();
        String contactEmail = leadToConvert.getEmail();
        String contactCompany = leadToConvert.getCompanyName();
        //create new Contact with Lead contact info and new id
        Contact newContact = new Contact(contactName, contactPhoneNumber, contactEmail, contactCompany);
        //ask user for product and number of trucks
        String newProductString = "";
        int newQuantity = 0;
        Scanner aScanner = new Scanner(System.in);
        System.out.println("Please provide the type of the product you're interested in\n Possible choices are: HYBRID, FLATBED, BOX\n");
        if (aScanner.hasNextLine()) {
            newProductString = aScanner.next();
        }
        System.out.println("Please provide the number of trucks you're interested in\n Maximum amount: 300");
        if (aScanner.hasNextLine()) {
            newQuantity = Integer.parseInt(aScanner.next());
        }
        //create new Opportunity with the above info
        Product newProduct = EnumHandler.getRequiredProduct(newProductString);
        Opportunity newOpportunity = new Opportunity(newProduct, newQuantity, newContact);
        System.out.println("Opportunity created. Lead ID: " + newOpportunity.getId());
        //Remove Lead
        removeLead(id);
        System.out.println("Lead deleted. Lead ID: " + leadToConvert.getId());
        //return new Account
        return setupAccount(newOpportunity);
    }

    public Account setupAccount(Opportunity opportunity) {
        //the user will be prompted for the industry, number of employees, city, and country of the organization
        String industryString = null; String city = null; int employeeCount = 0; String country = null;
        Scanner aScanner = new Scanner(System.in);
        System.out.println("Please provide the industry name\n Possible choices are: PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL, OTHER\n");
        if (aScanner.hasNextLine()) {
            industryString = aScanner.next();
        }
        System.out.println("Please provide the number of company employees\n");
        if (aScanner.hasNextLine()) {
            employeeCount = Integer.parseInt(aScanner.next());
        }
        System.out.println("Please provide the city name\n");
        if (aScanner.hasNextLine()) {
            city = aScanner.next();
        }
        System.out.println("Please provide the country name\n");
        if (aScanner.hasNextLine()) {
            country = aScanner.next();
        }
        Industry industry = EnumHandler.getRequiredIndustry(industryString);
        List<Contact> contactList = new ArrayList<>();
        List<Opportunity> opportunityList = new ArrayList<>();
        contactList.add(opportunity.getDecisionMaker());
        opportunityList.add(opportunity);
        Account newAccount = new Account(industry, employeeCount, city, country, contactList, opportunityList);
        System.out.println("Account created. Account ID: " + newAccount.getId());
        return newAccount;
    }

    public static Scanner createScanner() {
        Scanner aScanner = new Scanner(System.in);
        System.out.println("Please provide the correct value");
        if (aScanner.hasNextLine()) {
            return aScanner;
        }
    }
  
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

    public void updateOpportunityStatus(long id) {}
    public void IOHandler(){}
}
