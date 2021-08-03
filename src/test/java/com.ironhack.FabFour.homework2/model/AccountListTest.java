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

    private Contact testContact;
    private List<Contact> testContactList = new ArrayList<>();
    private Opportunity testOpportunity;
    private List<Opportunity> testOpportunityList = new ArrayList<>();
    private Account testAccount;

    @BeforeEach
    void setUp() {
        testContact = new Contact("Jane Doe", "123456789", "jane@gmail.com", "Jane Company");
        testContactList.add(testContact);

        testOpportunity = new Opportunity(Product.HYBRID, 12, testContact);
        testOpportunityList.add(testOpportunity);

        testAccount = new Account(Industry.MEDICAL, 100, "Beijing", "China", testContactList, testOpportunityList);
        accountList.add(testAccount);
    }

    @AfterEach
    void tearDown() {
        accountList.remove(testAccount);
        testOpportunityList.remove(testOpportunity);
        testContactList.remove(testContact);
    }

    @Test
    void AccountList_lookUpOpportunity_PositiveTest() {
        String id = String.valueOf(testOpportunity.getId());
        Opportunity otherOpportunity = lookUpOpportunity(id);

        assertEquals(testOpportunity, otherOpportunity);
    }

    @Test
    void AccountList_lookUpAccount_PositiveTest() {
        String id = String.valueOf(testAccount.getId());
        Account otherAccount = lookUpAccount(id);

        assertEquals(testAccount, otherAccount);
    }

    @Test
    void AccountList_lookUpOpportunity_NegativeTest() {
        assertEquals(null, lookUpOpportunity("9876"));
    }

    @Test
    void AccountList_lookUpAccount_NegativeTest() {
        assertEquals(null, lookUpAccount("12345"));
    }
}