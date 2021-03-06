package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.model.Account;
import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.Opportunity;
import org.apache.commons.lang.WordUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ironhack.FabFour.homework2.common.CommandHandler.getCountryList;
import static com.ironhack.FabFour.homework2.model.AccountList.accountList;
import static com.ironhack.FabFour.homework2.model.LeadList.getListOfLeads;

public class DataValidator {

    //Method to check if the input for the e-mail address has a correct form
    public static boolean validateEmail(String input) {
        final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    //Method to check if the input for the phone number has a correct form
    public static boolean validatePhoneNumber(String input) {
        String inputWithoutSpaces = input.replaceAll("-", "");
        final String regex = "^\\+?\\d{6,15}"; // Phone number should contain 6-15 digits and can include the country code

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputWithoutSpaces);
        return matcher.matches();
    }

    //Method to check if the input is empty
    public static boolean isEmpty(String input) {
        return input.isBlank();
    }

    //Method to check if a lead with a specific ID exists
    public static boolean leadExists(String input) {
        List<Lead> listOfLeads = getListOfLeads();

        long inputAsLong = Long.parseLong(input);

        for(Lead lead : listOfLeads) {
            long leadId = lead.getId();
            if(leadId == inputAsLong) return true;
        }

        return false;
    }

    //Method to check if an opportunity with the specific ID exists
    public static boolean opportunityExists(String input) {
        for(Account account : accountList) {
            Opportunity opportunity = account.getOpportunity(input);
            if(opportunity != null) {
                return true;
            }
        }
        return false;
    }

    //Method to check if a lead with the same information already exists
    public static boolean isDuplicateLead(Lead newLead) {
        List<Lead> listOfLeads = getListOfLeads();

        for(Lead lead : listOfLeads) {
            if(lead.equals(newLead)) return true;
        }
        return false;
    }

    //Method to check if an opportunity with the same information already exists
    public static boolean isDuplicateOpportunity(Opportunity inputOpportunity) {
        for(Account account : accountList) {
            List<Opportunity> opportunityList = account.getOpportunityList();
            for(Opportunity opportunity : opportunityList) {
                if(opportunity.equals(inputOpportunity)) return true;
            }
        }
        return false;
    }

    //Method to check if the String contains only letters and white spaces
    public static boolean containsOnlyLetters(String input) {
        final String regex = "^[ a-zA-Z]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    //Method to check if the String is an ISO country name
    public static boolean validateCountryName(String countryName) {
        List<String> countryList = getCountryList();
        boolean check = false;
        for(String country: countryList) {
            if(WordUtils.capitalizeFully(countryName).equals(country)) {
                check = true;
                break;
            }
        }
        return check;
    }
}
