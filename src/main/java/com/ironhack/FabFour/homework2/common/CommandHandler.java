package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.*;
import com.ironhack.FabFour.homework2.model.*;

import java.util.*;

import org.apache.commons.lang.WordUtils;

import static com.ironhack.FabFour.homework2.common.DataValidator.containsOnlyLetters;
import static com.ironhack.FabFour.homework2.common.DataValidator.isEmpty;
import static com.ironhack.FabFour.homework2.common.InputOutput.*;
import static com.ironhack.FabFour.homework2.model.AccountList.*;

public class CommandHandler {

    public static void handleCommand(String command) {
        String upperCommand = command.trim().toUpperCase(); // delete all spaces around command
        String defaultInfo = "Command not recognised. Try again or type: help"; //default info message
        long id = getIdFromInput(upperCommand); // get id from the end of command - if there is no long value then method returns 0;

        if (id < 1) { // case when command hasn't any id at the end
            switch (Command.getCommandType(upperCommand)) {
                case NEW_LEAD:
                    createLead();
                    break;
                case SHOW_LEADS:
                    LeadList.showLeads();
                    break;
                case EXPORT_LEADS:
                    exportLeadInformation();
                    break;
                case HELP:
                    System.out.println(
                            " Type one of below statement to execute :\n" +
                            " > new lead - " + "to create new lead\n" +
                            " > show leads - to show all of leads\n" +
                            " > export leads - to export all current leads\n" +
                            " > lookup lead {id} - to show specific lead\n" +
                            " > convert {id} - to convert lead to an opportunity\n" +
                            " > lookup opportunity {id} - to show specific opportunity\n" +
                            " > export opportunities {id} - to export all current opportunities\n" +
                            " > lookup account {id} - to show specific account\n" +
                            " > export accounts {id} - to export all accounts\n" +
                            " > close-won {id} - to close case after sale\n" +
                            " > close-lost {id} - to close case without sale\n" +
                            " > quit - to leave the app"
                    );
                    break;
                default:
                    System.out.println(defaultInfo);
            }
        } else { // case when command has an id at the end

            upperCommand = getTextWithoutId(upperCommand);

            switch (Command.getCommandType(upperCommand)) {
                case CONVERT:
                    convertLead(id);
                    break;
                case LOOKUP_LEAD:
                    voidChecker(lookupLead(id));
                    break;
                case LOOKUP_OPPORTUNITY:
                    voidChecker(lookUpOpportunity(String.valueOf(id)));
                    break;
                case LOOKUP_ACCOUNT:
                    voidChecker(lookUpAccount(String.valueOf(id)));
                    break;
                case EXPORT_OPPORTUNITIES:
                    exportOppInformation();
                    break;
                case EXPORT_ACCOUNTS:
                    exportAccountInformation();
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
        System.out.println("--------------------------------------------------");
    }

    public static void voidChecker(Object o) {
        if (o == null) {
            System.out.println("Please try again.");
        }
        else {
            System.out.println(o.toString());
        }
    }

    public static long getIdFromInput(String command) {
        String[] words = command.trim().split("\\s");

        try {
            return Long.parseLong(words[words.length - 1]);
        } catch (NumberFormatException ignored) {
        }
        return 0; // It returns 0 because you cannot create id less than 0
    }

    public static String getTextWithoutId(String text) {
        return text.substring(0, text.length() - String.valueOf(getIdFromInput(text)).length()).trim();
    }

    public static Account convertLead(long id) {
        //Wrapper method for converting Lead and setting up the Account object
        if(!DataValidator.leadExists(Long.toString(id))){
            System.out.println("Lead doesn't exist. Please provide the correct id.");
            return null;
        } else {
            Lead lead = lookupLead(id); //get Lead by ID
            Contact contact = createContact(lead); //create Contact object from Lead
            List<Object> accountData = getAccountInfo(id, contact); //obtain account data via user input
            return setupAccount(accountData); //return Account object from account data
        }
    }

    public static Contact createContact(Lead leadToConvert) {
        //Creates Contact object from Lead
        String contactName = leadToConvert.getContactName();
        String contactPhoneNumber = leadToConvert.getPhoneNumber();
        String contactEmail = leadToConvert.getEmail();
        String contactCompany = leadToConvert.getCompanyName();
        return new Contact(contactName, contactPhoneNumber, contactEmail, contactCompany);
    }

    public static List<Object> getAccountInfo(long id, Contact newContact){
        //Obtains account data from user input and Contact object
        System.out.println("Please provide the type of the product you're interested in.\nPossible choices are: HYBRID, FLATBED, BOX");
        Product newProduct = (Product) getEnumInput("product");
        System.out.println("Please provide the number of trucks you're interested in.\nMaximum amount: 300");
        int newQuantity = getIntInput("quantity");
        System.out.println("Please provide the industry name.\nPossible choices are: PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL, OTHER");
        Industry newIndustry = (Industry) getEnumInput("industry");
        System.out.println("Please provide the number of company employees");
        int employeeCount = getIntInput("employees");
        System.out.println("Please provide the city name");
        String city = getUserInput();
        System.out.println("Please provide the country name");
        String country = getUserInput();
        Opportunity newOpportunity = new Opportunity(newProduct, newQuantity, newContact);
        Lead leadToConvert = lookupLead(id);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Opportunity created. Opportunity ID: " + newOpportunity.getId() + "\n");
        removeLead(id);
        System.out.println("Lead with ID: " + leadToConvert.getId() +" has been deleted.");
        return Arrays.asList(newOpportunity, newIndustry, employeeCount, city, country);
    }

    public static Account setupAccount(List<Object> accountInfoList) {
        //Returns new Account Object from account data list
        Industry industry = (Industry) accountInfoList.get(1);
        int employees = (int) accountInfoList.get(2);
        String city = (String) accountInfoList.get(3);
        String country = (String) accountInfoList.get(4);
        List<Contact> contactList = new ArrayList<>();
        List<Opportunity> opportunityList = new ArrayList<>();
        contactList.add(((Opportunity) accountInfoList.get(0)).getDecisionMaker()); //decisionMaker for the Opportunity is added to contact list
        opportunityList.add((Opportunity) accountInfoList.get(0)); //Opportunity object is added to opportunity list
        Account newAccount = new Account(industry, employees, WordUtils.capitalizeFully(city), WordUtils.capitalizeFully(country), contactList, opportunityList);
        accountList.add(newAccount);
        System.out.println("Account created. Account ID: " + newAccount.getId());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        return newAccount;
    }

    public static boolean isInteger(String input) {
        //Checks if the input String can be parsed into Integer
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Object getEnumInput(String enumType) {
        //Processes user input used for setting enum values
        Scanner aScanner = new Scanner(System.in);
        Object result;
        while(aScanner.hasNextLine()) {
            try {
                String userInput = aScanner.nextLine();
                if (!isEmpty(userInput) && enumType.equals("product") && Product.getProduct(userInput) != null) {
                    result = Product.getProduct(userInput); //assigns enum value from valid input
                    return result;
                } else if (!isEmpty(userInput) && enumType.equals("industry") && Industry.getIndustry(userInput) != null) {
                    result = Industry.getIndustry(userInput); //assigns enum value from valid input
                    return result;
                } else {
                    errorMessage("Please provide the correct value.");
                }
            } catch (Exception e) { System.out.println("Exception is: " + e);}
        }
        return null;
    }

    public static int getIntInput(String intType) {
        //Processes user input used for setting int values
        Scanner aScanner = new Scanner(System.in);
        int result;
        int range = (intType.equals("quantity")) ? 300 : 3000000; //limit for quantity is 300, for employees 3000000
        while(aScanner.hasNextLine()) {
            try {
                String userInput = aScanner.nextLine();
                if (!isEmpty(userInput) && isInteger(userInput) && Integer.parseInt(userInput) > 0 && Integer.parseInt(userInput) <= range) {
                    result = Integer.parseInt(userInput);
                    return result;
                } else {
                    errorMessage("Please provide the correct value.");
                }
            } catch (Exception e) { System.out.println("Exception is: " + e); }
        }
        return 0;
    }

    public static String getUserInput() {
        //Processes user input used for setting String values
        Scanner aScanner = new Scanner(System.in);
        while(aScanner.hasNextLine()) {
            try {
                String input = aScanner.nextLine();
                if(!isEmpty(input) && containsOnlyLetters(input)) {
                    return input;
                } else {
                    errorMessage("Please provide the correct value.");
                }
            } catch (Exception e) { System.out.println("Exception is: " + e); }
        }
        return null;
    }

    public static String errorMessage(String message) {
        //Changes the color of System.output error messages
        String escapeCode = "\033[31m"; //sets color to red
        String resetCode = "\033[0m";   //resets color to the primary one
        System.out.println(escapeCode + message);
        System.out.println(resetCode);
        return message;
    }

    public static Lead createLead() {
        LeadList tester = new LeadList(); // created as a dummy whilst working out how to add objects to list
        String tempName;
        String tempNumber;
        String tempEmail;
        String tempCompany;
        Lead tempLead = null;
        try {
            Scanner aScanner = new Scanner(System.in);
            System.out.println("Please enter their contact name.");
            tempName = aScanner.nextLine();
            System.out.println("Please enter their phone number, with no spaces.");
            tempNumber = aScanner.nextLine();
            System.out.println("Please enter their email address.");
            tempEmail = aScanner.nextLine();
            System.out.println("Please enter their company's name");
            tempCompany = aScanner.nextLine();
            tempLead = new Lead(tempName, tempNumber, tempEmail, tempCompany);
            LeadList.getListOfLeads().add(tempLead);
            System.out.println("Lead created. Lead ID: " + tempLead.getId());
        }
        catch (Exception e) { System.out.println("Exception: " + e); }
        return tempLead;
    }

    public static Lead lookupLead(long id) {
        Lead foundLead = null;
        for (Lead aLead : LeadList.getListOfLeads()) {
            if (aLead.getId() == id) {
                foundLead = aLead;
                break;
            }
        }
        if(foundLead == null) {
            System.out.println("There is no lead with id "+id);
        }

        return foundLead;
    }

    public static void removeLead(long id) {
        for (Lead aLead : LeadList.getListOfLeads()) {
            if (aLead.getId() == id) {
                LeadList.getListOfLeads().remove(aLead);
                break;
            }
        }
    }

    // Update opportunity status to closed-lost
    public static void updateOpportunityStatusClosedLost(long id) {
        boolean found = false;
        for (Account account : accountList) {
            Opportunity opportunity = account.getOpportunity(String.valueOf(id));
            if (opportunity != null) {
                opportunity.setStatus(Status.CLOSED_LOST);
                System.out.println("The opportunity status has been set to 'closed-lost'.");
                found = true;
                break;}}
        if(found == false) {
            System.out.println("There is no opportunity with this ID. Please try again.");
        }
    }

    // Update opportunity status to closed-won
    public static void updateOpportunityStatusClosedWin(long id) {
        boolean found = false;
        for (Account account : accountList) {
            Opportunity opportunity = account.getOpportunity(String.valueOf(id));
            if (opportunity != null) {
                opportunity.setStatus(Status.CLOSED_WON);
                System.out.println("The opportunity status has been set to 'closed-won'.");
                found = true;
                break;}}
        if(found == false) {
            System.out.println("There is no opportunity with this ID. Please try again.");
        }
    }
}
