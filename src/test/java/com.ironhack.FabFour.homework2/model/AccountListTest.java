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
    private Contact contact9;
    private List<Contact> contactList9 = new ArrayList<>();
    private Opportunity opportunity9;
    private List<Opportunity> opportunityList9 = new ArrayList<>();
    private String opportunityIdAsString9;
    private Account account9;
    private String accountIdAsString9;

    /*
    @Test
    void AccountList_lookUpOpportunity_PositiveTest() {
        contact9 = new Contact("Mary Jane", "333222111", "maryJ@yahoo.com", "Jane's Emporium");
        contactList9.add(contact9);

        opportunity9 = new Opportunity(Product.FLATBED, 25, contact9);
        opportunityList9.add(opportunity9);
        opportunityIdAsString9 = String.valueOf(opportunity9.getId());

        account9 = new Account(Industry.ECOMMERCE, 12, "Paris", "France", contactList9, opportunityList9);
        accountList.add(account9);

        assertEquals(opportunity9, lookUpOpportunity(opportunityIdAsString9));

        accountList.remove(account9);
        contactList9.remove(contact9);
    }

     */

    @Test
    void AccountList_lookUpOpportunity_NegativeTest() {
        assertEquals(null, lookUpOpportunity("9876"));
    }

    /*
    @Test
    void AccountList_lookUpAccount_PositiveTest() {

        Contact contact8 = new Contact("John Doe", "123456789", "peter_parker@yahoo.com", "Parker Company");
        List<Contact> contactList8 = new ArrayList<>();
        contactList8.add(contact8);

        Opportunity opportunity8 = new Opportunity(Product.HYBRID, 15, contact8);
        List<Opportunity> opportunityList8 = new ArrayList<>();
        opportunityList8.add(opportunity8);

        Account account8 = new Account(Industry.MANUFACTURING, 25, "Berlin", "Germany", contactList8, opportunityList8);
        accountList.add(account8);
        String accountIdAsString8 = String.valueOf(account8.getId());

        assertEquals(account8, lookUpAccount(accountIdAsString8));

        accountList.remove(account8);
        contactList9.remove(contact8);
    }

     */

    @Test
    void AccountList_lookUpAccount_NegativeTest() {
        assertEquals(null, lookUpAccount("12345"));
    }
}