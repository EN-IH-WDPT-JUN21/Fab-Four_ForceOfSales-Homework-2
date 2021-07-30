package com.ironhack.FabFour.homework2.model;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    public static List<Account> accountList = new ArrayList<>();

    //Method that looks for the opportunity and prints it when found
    public static String lookUpOpportunity(String id) {
        String foundOpportunity = null;
        for(Account account : accountList) {
            Opportunity opportunity = account.getOpportunity(id);
            if(opportunity != null) {
                foundOpportunity = opportunity.toString();
                System.out.println(foundOpportunity);
                break;}}
        if(foundOpportunity == null) {
            System.out.println("There is no opportunity with this ID. Please try again.");
        }

        return foundOpportunity;
    }

    //Method that looks for the account and prints it when found
    public static String lookUpAccount(String id) {
        String foundAccount = null;
        for(Account account : accountList) {
            long accountId = account.getId();
            if(Long.parseLong(id) == accountId) {
                foundAccount = account.toString();
                System.out.println(foundAccount);
                break;}}
        if(foundAccount == null) {
            System.out.println("There is no account with this ID. Please try again.");
        }
        return foundAccount;
    }
}
