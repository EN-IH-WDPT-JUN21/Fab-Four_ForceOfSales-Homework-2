package com.ironhack.FabFour.homework2.model;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    public static List<Account> accountList = new ArrayList<>();
    //Method that looks for the opportunity and prints it when found
    public static Opportunity lookUpOpportunity(String id) {
        Opportunity foundOpportunity = null;
        for(Account account : accountList) {
            Opportunity opportunity = account.getOpportunity(id);
            if(opportunity != null) {
                foundOpportunity = opportunity;
                break;}}
        if(foundOpportunity == null) {
            System.out.println("There is no opportunity with id " + id);
        }
        return foundOpportunity;
    }
    //Method that looks for the account and prints it when found
    public static Account lookUpAccount(String id) {
        Account foundAccount = null;
        for(Account account : accountList) {
            long accountId = account.getId();
            if(Long.parseLong(id) == accountId) {
                foundAccount = account;
                break;}}
        if(foundAccount == null) {
            System.out.println("There is no account with id " + id);
        }
        return foundAccount;
    }
}