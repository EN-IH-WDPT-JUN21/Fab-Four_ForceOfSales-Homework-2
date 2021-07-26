package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.enums.Industry;
import com.ironhack.FabFour.homework2.enums.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.ironhack.FabFour.homework2.common.CommandHandler.accountList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    @Test
    void getOpportunity_correct() {
        List<Contact> testContactList = new ArrayList<Contact>();
        Contact testContact = new Contact("Rick","0208","rick@westley","Zombies");
        testContactList.add(testContact);

        List<Opportunity> testOpportunityList = new ArrayList<Opportunity>();
        Opportunity testOpportunity = new Opportunity(Product.HYBRID, 3, testContact);
        testOpportunityList.add(testOpportunity);

        Account testAccount = new Account(Industry.ECOMMERCE, 2, "Berlin", "Germany", testContactList, testOpportunityList);
        assertEquals(testOpportunity, testAccount.getOpportunity("1001"));
    }
}
