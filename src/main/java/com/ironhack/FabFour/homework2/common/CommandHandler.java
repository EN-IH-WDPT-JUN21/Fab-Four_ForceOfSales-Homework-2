package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Command;
import com.ironhack.FabFour.homework2.enums.Status;
import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.LeadList;
import com.ironhack.FabFour.homework2.model.Opportunity;
import com.ironhack.FabFour.homework2.enums.*;
import com.ironhack.FabFour.homework2.model.*;

import java.util.*;

import org.apache.commons.lang.WordUtils;

import java.io.IOException;
import java.text.ParseException;

public class CommandHandler {
  
    public void handleCommand(String command) {
        String upperCommand = command.trim().toUpperCase(); // delete all spaces around command
        String defaultInfo = "Command not recognised. Type HELP or try again!"; //default info message
        long id = getIdFromInput(upperCommand); // get id from the end of command - if there is no long value then method returns 0;

        if(id<1) { // case when command hasn't any id at the end
            switch(Command.getCommandType(upperCommand)) {
                case NEW_LEAD:
                    createLead();
                    break;
                case SHOW_LEADS:
                    LeadList leadList = new LeadList();
                    leadList.showLeads();
                    break;
                case HELP:
                    System.out.println("--------------------------------------------------\n" +
                            " Type one of below statement to execute :\n" +
                            " > new lead - " + "to create new lead\n" +
                            " > show leads - to show all of leads\n" +
                            " > lookup lead {id} - to show specific lead\n" +
                            " > convert {id} - to convert lead to an opportunity\n" +
                            " > close-win {id} - to close case after sale\n" +
                            " > close-lost {id} - to  close case without sale\n" +
                            "--------------------------------------------------"
                    );
                    break;
                default:
                    System.out.println(defaultInfo);
            }
        } else { // case when command has an id at the end

            upperCommand = upperCommand.substring(0,upperCommand.length()-String.valueOf(id).length()).trim();

            switch(Command.getCommandType(upperCommand)) {
                case CONVERT:
                    convertLead(id);
                    break;
                case LOOKUP_LEAD:
                    lookupLead(id);
                    break;
                case CLOSE_WON:
                    updateOpportunityStatusClosedWin(id);
                    break;
                case CLOSE_LOST:
                    updateOpportunityStatusClosedLost(id);
                    break;
                default:
                    System.out.println(defaultInfo);
            }
        }
    }

    public static long getIdFromInput(String command) {
        String[] words = command.trim().split("\\s");

        try {
            return Long.parseLong(words[words.length-1]);
        } catch(NumberFormatException ignored) {
        }
        return 0; // It returns 0 because you cannot create id less than 0
    }
  
    //public?
    public static List<Account> accountList;

    public Account convertLead(long id) {
        Lead leadToConvert = lookupLead(id);
        String contactName = leadToConvert.getContactName();
        String contactPhoneNumber = leadToConvert.getPhoneNumber();
        String contactEmail = leadToConvert.getEmail();
        String contactCompany = leadToConvert.getCompanyName();
        Contact newContact = new Contact(contactName, contactPhoneNumber, contactEmail, contactCompany);
        System.out.println("Please provide the type of the product you're interested in.\nPossible choices are: HYBRID, FLATBED, BOX");
        Product newProduct = (Product) getEnumInput("product");
        System.out.println("Please provide the number of trucks you're interested in.\nMaximum amount: 300");
        int newQuantity = getIntInput("quantity");
        Opportunity newOpportunity = new Opportunity(newProduct, newQuantity, newContact);
        System.out.println("Opportunity created. Lead ID: " + newOpportunity.getId());
        removeLead(id);
        System.out.println("Lead deleted. Lead ID: " + leadToConvert.getId());
        return setupAccount(newOpportunity, getAccountInfo());
    }

    public List getAccountInfo() {
        System.out.println("Please provide the industry name.\nPossible choices are: PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL, OTHER");
        Industry newIndustry = (Industry) getEnumInput("industry");
        System.out.println("Please provide the number of company employees");
        int employeeCount = getIntInput("employees");
        System.out.println("Please provide the city name");
        String city = getUserInput();
        System.out.println("Please provide the country name");
        String country = getUserInput();
        List<Object> accountInfoList = Arrays.asList(newIndustry, employeeCount, city, country);
        return accountInfoList;
    }

    public Account setupAccount(Opportunity opportunity, List<Object> accountInfoList) {
        Industry industry = (Industry) accountInfoList.get(0);
        int employees = (int) accountInfoList.get(1);
        String city = (String) accountInfoList.get(2);
        String country = (String) accountInfoList.get(3);
        List<Contact> contactList = new ArrayList<>();
        List<Opportunity> opportunityList = new ArrayList<>();
        contactList.add(opportunity.getDecisionMaker());
        opportunityList.add(opportunity);
        Account newAccount = new Account(industry, employees, WordUtils.capitalizeFully(city), WordUtils.capitalizeFully(country), contactList, opportunityList);
        System.out.println("Account created. Account ID: " + newAccount.getId());
        return newAccount;
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    public static Scanner createScanner() {
        Scanner aScanner = new Scanner(System.in);
        System.out.println("Please provide the correct value");
        if (aScanner.hasNextLine()) {
            return aScanner;
        }
        return null;
    }

    public Object getEnumInput(String enumType) {
        Scanner aScanner = new Scanner(System.in);
        Object result = null;
        if (aScanner.hasNextLine()) {
            if(enumType == "product") {
                result = EnumHandler.getRequiredProduct(aScanner.next());
            } else if(enumType == "industry") {
                result = EnumHandler.getRequiredIndustry(aScanner.next());
            }
        }
        if(result == null) {
            System.out.println("Please provide the correct value.");
            getEnumInput(enumType);
        }
        return result;
    }

    public int getIntInput(String intType) {
        Scanner aScanner = new Scanner(System.in);
        int result = 0;
        if (aScanner.hasNextLine()) {
            String userInput = aScanner.next();
            if(isInteger(userInput)) {
                result =  Integer.parseInt(userInput);
            } else {
                System.out.println("Please provide the correct value.");
                getIntInput(intType);
            }
        }
        return result;
    }

    public String getUserInput() {
        Scanner aScanner = new Scanner(System.in);
        String result = "";
        if (aScanner.hasNextLine()) {
            result = aScanner.next();
        }
        return result;
    }

    public static void main(String[] args) {
       
    }

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

    /*
    public void updateOpportunityStatus(long id) {}
    -- REMOVED the method and split it in two
     */

    public void updateOpportunityStatusClosedLost(long id) {
        for(Account account : accountList) {
            Opportunity opportunity = account.getOpportunity(String.valueOf(id));
            if(opportunity != null) {
                opportunity.setStatus(Status.CLOSED_LOST);
            }
        }
    }

    public void updateOpportunityStatusClosedWin(long id) {
        for(Account account : accountList) {
            Opportunity opportunity = account.getOpportunity(String.valueOf(id));
            if(opportunity != null) {
                opportunity.setStatus(Status.CLOSED_WON);
            }
        }
    }

    public void IOHandler(){}
}
