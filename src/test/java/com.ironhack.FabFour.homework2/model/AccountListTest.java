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
    void AccountList_lookUpOpportunity_PositiveTest() {
        contact = new Contact("Mary Jane", "333222111", "maryJ@yahoo.com", "Jane's Emporium");
        contactList.add(contact);

        opportunity = new Opportunity(Product.FLATBED, 25, contact);
        opportunityList.add(opportunity);
        opportunityIdAsString = String.valueOf(opportunity.getId());

        account = new Account(Industry.ECOMMERCE, 12, "Paris", "France", contactList, opportunityList);
        accountList.add(account);

        assertEquals(opportunity, lookUpOpportunity(opportunityIdAsString));

        accountList.remove(account);
    }

    @Test
    void AccountList_lookUpOpportunity_NegativeTest() {
        assertEquals(null, lookUpOpportunity("9876"));
    }

    @Test
    void AccountList_lookUpAccount_PositiveTest() {

        Contact contact2 = new Contact("Peter Parker", "123456789", "peter_parker@yahoo.com", "Parker Company");
        List<Contact> contactList2 = new ArrayList<>();
        contactList2.add(contact2);

        Opportunity opportunity2 = new Opportunity(Product.HYBRID, 15, contact2);
        List<Opportunity> opportunityList2 = new ArrayList<>();
        opportunityList2.add(opportunity2);

        Account account2 = new Account(Industry.MANUFACTURING, 25, "Berlin", "Germany", contactList2, opportunityList2);
        accountList.add(account2);
        accountIdAsString = String.valueOf(account2.getId());

        assertEquals(account2, lookUpAccount(accountIdAsString));

        accountList.remove(account2);
    }

    @Test
    void AccountList_lookUpAccount_NegativeTest() {
        assertEquals(null, lookUpAccount("12345"));
    }
}