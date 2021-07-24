package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Industry;
import com.ironhack.FabFour.homework2.enums.Product;
import com.ironhack.FabFour.homework2.model.*;

import java.util.ArrayList;
import java.util.List;
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
        Product newProduct = getRequiredProduct(newProductString);
        Opportunity newOpportunity = new Opportunity(newProduct, newQuantity, newContact);
        //Remove Lead
        removeLead(id);
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
        Industry industry = getRequiredIndustry(industryString);
        List<Contact> contactList = new ArrayList<>();
        List<Opportunity> opportunityList = new ArrayList<>();
        contactList.add(opportunity.getDecisionMaker());
        opportunityList.add(opportunity);
        Account newAccount = new Account(industry, employeeCount, city, country, contactList, opportunityList);
        return newAccount;
    }

    public static Product getRequiredProduct(String productString) {
        Product product = null;
        switch (productString.toUpperCase()) {
            case "FLATBED":
                product = Product.FLATBED;
                break;
            case "HYBRID":
                product = Product.HYBRID;
                break;
            case "BOX":
                product = Product.BOX;
                break;
        }
        return product;
    }

    public static Industry getRequiredIndustry(String industryString) {
        Industry industry = null;
        switch (industryString.toUpperCase()) {
            case "PRODUCE":
                industry = industry.PRODUCE;
                break;
            case "ECOMMERCE":
                industry = industry.ECOMMERCE;
                break;
            case "MANUFACTURING":
                industry = industry.MANUFACTURING;
                break;
            case "MEDICAL":
                industry = industry.MEDICAL;
                break;
            case "OTHER":
                industry = industry.OTHER;
                break;
        }
        return industry;
    }
}
