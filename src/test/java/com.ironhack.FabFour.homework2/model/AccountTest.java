package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.enums.Industry;
import com.ironhack.FabFour.homework2.enums.Product;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    static Contact contact;
    static Opportunity opportunity;
    static Contact contact1;
    static Account account;
    static InputStream standardIn;
    Account account1;
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
        assertEquals(2001, account.getId());
        account1 = new Account(Industry.OTHER, 4, "NY", "USA", contactList, opportunityList);
        assertEquals(2002, account1.getId());
    }

    @Test
    @DisplayName("Test: setIndustry(). Industry set as expected.")
    public void Account_SetIndustry_IndustrySet(){
        account.setIndustry(Industry.PRODUCE);
        assertEquals(Industry.PRODUCE, account.getIndustry());
    }

    @Test
    @DisplayName("Test: setEmployeeCount. EmployeeCount set as expected.")
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
    @DisplayName("Test: setString(). String attributes set as expected.")
    public void Account_SetString_CityStringSet() {
        InputStream in = new ByteArrayInputStream("Montreal".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        account.setString("city", sc);
        assertTrue(account.getCity() instanceof String);
        assertEquals("Montreal", account.getCity());
    }

    @Test
    @DisplayName("Test: setString(). String attributes set as expected.")
    public void Account_SetString_CountryStringSet() {
        InputStream in = new ByteArrayInputStream("Canada".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        account.setString("country", sc);
        assertTrue(account.getCountry() instanceof String);
        assertEquals("Canada", account.getCountry());
    }

    @Test
    @DisplayName("Test: setInteger(). Integer attributes set as expected.")
    public void Account_SetInteger_IntegerSet(){
        InputStream in = new ByteArrayInputStream("210".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        account.setInteger(sc);
        assertEquals(account.getEmployeeCount(), 210);
    }

    @Test
    @DisplayName("Test: setInteger(). Integer attributes not set as invalid input provided.")
    public void Account_SetInteger_IntegerNotSet(){
        InputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        assertThrows(NullPointerException.class, () ->  account.setInteger(sc));
    }

    @Test
    @DisplayName("Test: setEnum(). Enum attributes set as expected.")
    public void Account_SetEnum_EnumSet(){
        InputStream in = new ByteArrayInputStream("medical".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        account.setEnum(sc);
        assertEquals(account.getIndustry(), Industry.MEDICAL);
    }

    @Test
    @DisplayName("Test: setEnum(). Enum attributes not set as invalid input provided.")
    public void Account_SetEnum_EnumNotSet(){
        InputStream in = new ByteArrayInputStream("arts".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        assertThrows(NullPointerException.class, () ->  account.setEnum(sc));
    }
}
