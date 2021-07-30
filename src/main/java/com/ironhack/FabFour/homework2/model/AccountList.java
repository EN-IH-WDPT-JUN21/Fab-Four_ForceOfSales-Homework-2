package com.ironhack.FabFour.homework2.model;

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    public static List<Account> accountList = new ArrayList<>();

    public static String lookUpOpportunity(String id) {
        for(Account account : accountList) {
            Opportunity opportunity = account.getOpportunity(id);
            if(opportunity != null) {
                return opportunity.toString();}}
        return null;
    }

    public static String lookUpAccount(String id) {
        for(Account account : accountList) {
            long accountId = account.getId();
            if(Long.parseLong(id) == accountId) {
                return account.toString();}}
        return null;
    }
}
