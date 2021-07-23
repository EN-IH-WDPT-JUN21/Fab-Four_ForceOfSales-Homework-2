package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.model.Lead;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        final String regex =
                "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    //Method to check if the input is empty
    public boolean isEmpty(String input) {
        return input.isBlank();
    }

    // Method to check if lead exists
    /*
    public static boolean leadExists(String input) {
        List<Lead> listOfLeads = getListOfLeads();

        try {
            long inputAsLong = Long.parseLong(input);

            for(Lead lead : listOfLeads) {
                long leadId = lead.getId();
                if(leadId == inputAsLong) return true;
                break;
            }
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: The input value must be a number of type long.");
        }
        return false;
    }
     */

    //TODO: public static boolean opportunityExists()

    public boolean inputLength() {return false;}


    //Method to check if the lead already exists
    /*
    public static boolean isDuplicateLead(Lead newLead) {
        List<Lead> listOfLeads = getListOfLeads();

        for(Lead lead : listOfLeads) {
            if(lead.equals(newLead)) return true;
            break;
        }
        return false;}
     */

    //TODO: public static boolean isDuplicateOpportunity
}
