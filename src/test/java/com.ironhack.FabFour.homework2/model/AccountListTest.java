package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.enums.Industry;
import com.ironhack.FabFour.homework2.enums.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.ironhack.FabFour.homework2.model.AccountList.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountListTest {
    private Contact contact;
    private List<Contact> contactList = new ArrayList<>();
    private Opportunity opportunity;
    private List<Opportunity> opportunityList = new ArrayList<>();
    private String opportunityIdAsString;
    private Account account;
    private String accountIdAsString;

    @Test
    void lookUpOpportunity_correct() {
        contact = new Contact("Mary Jane", "333222111", "maryJ@yahoo.com", "Jane's Emporium");
        contactList.add(contact);

        opportunity = new Opportunity(Product.FLATBED, 25, contact);
        opportunityList.add(opportunity);
        opportunityIdAsString = String.valueOf(opportunity.getId());

        account = new Account(Industry.ECOMMERCE, 12, "Paris", "France", contactList, opportunityList);
        accountList.add(account);
        accountIdAsString = String.valueOf(account.getId());

        assertEquals(opportunity.toString(), lookUpOpportunity(opportunityIdAsString));
    }

    @Test
    void lookUpOpportunity_wrong() {
        assertEquals(null, lookUpOpportunity("9876"));
    }

    /* TODO: Needs to be updated
    @Test
    void lookUpAccount_correct() {

        Account account2 = new Account(Industry.MANUFACTURING, 25, "Berlin", "Germany", contactList, opportunityList);
        accountList.add(account2);
        accountIdAsString = String.valueOf(account2.getId());

        assertEquals(account2.toString(), lookUpAccount(accountIdAsString));
    }

     */

    @Test
    void lookUpAccount_wrong() {
        assertEquals(null, lookUpAccount("12345"));
    }
}