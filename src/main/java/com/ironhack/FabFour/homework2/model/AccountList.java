package com.ironhack.FabFour.homework2.model;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    public static List<Account> accountList = new ArrayList<>();

    public static String lookUpOpportunity(String id) {
        String foundOpportunity = null;
        for(Account account : accountList) {
            Opportunity opportunity = account.getOpportunity(id);
            if(opportunity != null) {
                foundOpportunity = opportunity.toString();
                break;}}
        if(foundOpportunity == null) {
            System.out.println("There is no opportunity with this ID. Please try again.");
        }
        System.out.println(foundOpportunity);
        return foundOpportunity;
    }

    public static String lookUpAccount(String id) {
        String foundAccount = null;
        for(Account account : accountList) {
            long accountId = account.getId();
            if(Long.parseLong(id) == accountId) {
                foundAccount = account.toString();
                break;}}
        if(foundAccount == null) {
            System.out.println("There is no account with this ID. Please try again.");
        }
        System.out.println(foundAccount);
        return foundAccount;
    }
}
