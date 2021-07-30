package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.enums.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountTest {

    static Account account;
    Account account1;
    static Contact contact;
    static Opportunity opportunity;
    static Contact contact1;
    static InputStream standardIn;
    static List<Contact> contactList = new ArrayList<>();
    static List<Opportunity> opportunityList = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        standardIn = System.in;
        contact = new Contact("Mary Jane", "333222111", "maryJ@yahoo.com", "Jane's Emporium");
        contact1 = new Contact("Peter Parker", "999888777", "peterP@yahoo.com", "Webs");
        opportunity = new Opportunity(Product.FLATBED, 25, contact);
        contactList.add(contact);
        opportunityList.add(opportunity);
        account = new Account(Industry.ECOMMERCE, 12, "Paris", "France", contactList, opportunityList);
    }

    @AfterEach
    public void tearDown() {
        System.setIn(standardIn);
    }

    @Test
    @DisplayName("Test: setId(). Id incremented as expected.")
    public void Account_SetId_IdIncremented(){
        long AccountId = account.getId();
        assertEquals(2002, AccountId);
        account1 = new Account(Industry.OTHER, 4, "NY", "USA", contactList, opportunityList);
        assertEquals(++AccountId, account1.getId());
    }

    @Test
    @DisplayName("Test: setIndustry(). Industry set as expected.")
    public void Account_SetIndustry_IndustrySet(){
        account.setIndustry(Industry.PRODUCE);
        assertEquals(Industry.PRODUCE, account.getIndustry());
    }

    @Test
    @DisplayName("Test: setEmployeeCount(). EmployeeCount set as expected.")
    public void Account_SetEmployeeCount_EmployeeCountSet(){
        account.setEmployeeCount(15);
        assertEquals(15, account.getEmployeeCount());
    }

    @Test
    @DisplayName("Test: setCity(). City set as expected.")
    public void Account_SetCity_CitySet(){
        account.setCity("Krakow");
        assertEquals("Krakow", account.getCity());
    }

    @Test
    @DisplayName("Test: setCountry(). Country set as expected.")
    public void Account_SetCountry_CountrySet(){
        account.setCountry("Poland");
        assertEquals("Poland", account.getCountry());
    }

    @Test
    @DisplayName("Test: getContactList(). ContactList is of type List and size of 1 as expected.")
    public void Account_getContactList_ContactListIsAListOfLength1() {
        assertTrue(account.getContactList() instanceof List);
        assertEquals(1, account.getContactList().size());
    }

    @Test
    @DisplayName("Test: getOpportunityList(). OpportunityList is of type List and size of 1 as expected.")
    public void Account_getOpportunityList_OpportunityListIsAListOfLength1() {
        assertTrue(account.getOpportunityList() instanceof List);
        assertEquals(1, account.getOpportunityList().size());
    }

    @Test
    @DisplayName("Test: setCountry(). Country set as expected despite empty initial input.")
    public void Account_SetCountry_CountrySetAfterEmptyInputProvided(){
        InputStream in = new ByteArrayInputStream("Italy".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        account.setCountry("");
        assertFalse(account.getCountry().equals(""));
    }

    @Test
    @DisplayName("Test: setCity(). City set as expected despite empty initial input.")
    public void Account_SetCity_CitySetAfterEmptyInputProvided(){
        InputStream in = new ByteArrayInputStream("Los Angeles".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        account.setCity("");
        assertFalse(account.getCity().equals(""));
    }

    @Test
    @DisplayName("Test: setString(). String attributes set as expected.")
    public void Account_SetString_CityStringSet() {
        InputStream in = new ByteArrayInputStream("Montreal".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        account.setString("city", sc);
        assertEquals("Montreal", account.getCity());
    }

    @Test
    @DisplayName("Test: setString(). String attributes set as expected.")
    public void Account_SetString_CountryStringSet() {
        InputStream in = new ByteArrayInputStream("Canada".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        account.setString("country", sc);
        assertEquals("Canada", account.getCountry());
    }

    @Test
    @DisplayName("Test: getOpportunity(). Return correct Opportunity object as expected.")
    void Account_getOpportunity_correct_OpportunityReturned() {
        List<Contact> testContactList = new ArrayList<Contact>();
        Contact testContact = new Contact("Rick","07949 2222","rick@westley.com","Zombies");
        testContactList.add(testContact);

        List<Opportunity> testOpportunityList = new ArrayList<Opportunity>();
        Opportunity testOpportunity = new Opportunity(Product.HYBRID, 3, testContact);
        String opportunityId = String.valueOf(testOpportunity.getId());
        testOpportunityList.add(testOpportunity);

        Account testAccount = new Account(Industry.ECOMMERCE, 2, "Berlin", "Germany", testContactList, testOpportunityList);
        assertEquals(testOpportunity, testAccount.getOpportunity(opportunityId));
    }

    @Test
    @DisplayName("Test: getOpportunity(). Return nul as Opportunity doesn't exist.")
    void Account_getOpportunity_correct_OpportunityNotReturned() {
        List<Contact> testContactList = new ArrayList<Contact>();
        Contact testContact = new Contact("Rick","07949 2222","rick@westley.com","Zombies");
        testContactList.add(testContact);

        List<Opportunity> testOpportunityList = new ArrayList<Opportunity>();
        Opportunity testOpportunity = new Opportunity(Product.HYBRID, 3, testContact);
        testOpportunityList.add(testOpportunity);

        Account testAccount = new Account(Industry.ECOMMERCE, 2, "Berlin", "Germany", testContactList, testOpportunityList);
        assertEquals(null, testAccount.getOpportunity("900"));
    }

    @Test
    @DisplayName("Test: equals(). Two Account objects are equal as expected.")
    public void Account_equals_areEqual(){
        account = new Account(Industry.ECOMMERCE, 12, "Paris", "France", contactList, opportunityList);
        Account equalAccount = new Account(Industry.ECOMMERCE, 12, "Paris", "France", contactList, opportunityList);
        assertTrue(account.equals(account));
        assertTrue(account.equals(equalAccount));
    }

    @Test
    @DisplayName("Test: toString(). Positive Test.")
    public void Account_ToStringTest_ValidateString() {
        String testString = "Account: " + account.getId() + ", Industry: " + account.getIndustry() + ", Number of employees: " +
                account.getEmployeeCount() + ", City: " + account.getCity() + ", Country: " + account.getCountry() +
                    ", Contact:" + account.getContactList().get(0).getContactName() + ", Opportunity ID:" + account.getOpportunityList().get(0).getId();
        assertTrue(testString.equals(account.toString()));
    }
}
