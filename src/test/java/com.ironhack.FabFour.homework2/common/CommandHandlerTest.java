package com.ironhack.FabFour.homework2.common;

import org.junit.jupiter.api.Test;

import static com.ironhack.FabFour.homework2.common.CommandHandler.*;
import static com.ironhack.FabFour.homework2.model.AccountList.accountList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ironhack.FabFour.homework2.enums.*;
import com.ironhack.FabFour.homework2.model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandHandlerTest {

    CommandHandler test;
    Lead tempLeadOne = null;
    Lead tempLeadTwo;
    Opportunity newOpportunity;
    Contact newContact;
    List<Object> accountInfoList;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        test = new CommandHandler();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Test: createLead(). Validate that newly created lead is added to LeadList.")
    public void CommandHandler_CreateLeadTest_ValidateLeadAddedToList() {
        var currentListSize = LeadList.getListOfLeads().size();
        String username= "Jack"; String phoneNumber= "0794922"; String email = "test@test.com"; String company = "Company";
        String simulatedInput = username + System.getProperty("line.separator") +
                phoneNumber +  System.getProperty("line.separator") + email +
                System.getProperty("line.separator") + company +  System.getProperty("line.separator");
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        test.createLead();
        System.setIn(savedStandardInputStream);
        assertTrue(LeadList.getListOfLeads().size() == currentListSize + 1);
    }

    @Test
    @DisplayName("Test: lookupLead(). Return the lead as expected.")
    public void CommandHandler_LookupLead_LeadReturned() {
        tempLeadOne = new Lead("Buzz", "0794922", "buzz@lightyear.com", "Toy Story");
        LeadList.getListOfLeads().add(tempLeadOne);
        long tempID = tempLeadOne.getId();
        Lead tempLeadTwo = test.lookupLead(tempID);
        assertTrue(tempID == tempLeadTwo.getId());
    }

    @Test
    @DisplayName("Test: lookupLead(). Do not return the lead, as not in list.")
    public void CommandHandler_LookupLead_LeadNotReturned() {
        Lead tempLead = test.lookupLead(99);
        assertNull(tempLead);
    }

    @Test
    @DisplayName("Test: removeLead(). Remove the lead as expected.")
    public void CommandHandler_RemoveLead_LeadRemoved() {
        tempLeadOne = new Lead("Buzz", "07949222", "buzz@lightyear.com", "Toy Story");
        LeadList.getListOfLeads().add(tempLeadOne);
        int currentListSize = LeadList.getListOfLeads().size();
        test.removeLead(tempLeadOne.getId());
        int updatedListSize = LeadList.getListOfLeads().size();
        assertTrue(currentListSize == updatedListSize + 1);
    }

    @Test
    @DisplayName("Test: removeLead(). Do not remove lead, as ID doesn't exist.")
    public void CommandHandler_RemoveLead_LeadNotRemoved() {
        int currentListSize = LeadList.getListOfLeads().size();
        test.removeLead(99);
        int updatedListSize = LeadList.getListOfLeads().size();
        assertTrue(currentListSize == updatedListSize);
    }

    @Test
    @DisplayName("Test: createContact(). Contact created as expected.")
    public void CommandHandler_CreateContact_ContactCreated() {
        tempLeadTwo = new Lead("Mick", "987654321", "mick@yahoo.com", "Stones");
        Contact newContact = createContact(tempLeadTwo);
        assertEquals("987654321", newContact.getPhoneNumber());
    }

    @Test
    @DisplayName("Test: getAccountInfo(). Account Info list returned as expected.")
    public void CommandHandler_getAccountInfo_AccountInfoListReturned() {
        String industry = "other";
        String numOfEmployees = "12";
        String city = "Paris";
        String country = "France";
        String simulatedInput = industry + System.getProperty("line.separator") + numOfEmployees + System.getProperty("line.separator") + city + System.getProperty("line.separator") + country + System.getProperty("line.separator");
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        List<Object> obj = test.getAccountInfo();
        System.setIn(savedStandardInputStream);
        assertTrue(obj.size() > 0);
        assertEquals(Industry.OTHER, obj.get(0));
    }

    @Test
    @DisplayName("Test: isInteger(). Return correct boolean value.")
    public void CommandHandler_isInteger_CorrectValueReturned() {
        InputStream in = new ByteArrayInputStream("11".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        assertTrue(test.isInteger("11"));
        in = new ByteArrayInputStream("hello".getBytes());
        System.setIn(in);
        assertFalse(test.isInteger("hello"));
    }

    @Test
    @DisplayName("Test: convertLead(). Lead not converted as it doesn't exist.")
    public void CommandHandler_convertLead_LeadNotConvertedNoSuchLead() {
        assertEquals(null, convertLead(000));
    }

    @Test
    @DisplayName("Test: createOpportunity(). Opportunity created as expected.")
    public void CommandHandler_createOpportunity_OpportunityCreated() {
        String newProduct = "hybrid"; String numOfTrucks = "200";
        tempLeadTwo = new Lead("Mick", "987654321", "mick@yahoo.com", "Stones");
        long leadId = tempLeadTwo.getId();
        LeadList.getListOfLeads().add(tempLeadTwo);
        Contact newContact = createContact(tempLeadTwo);
        String simulatedInput = newProduct + System.getProperty("line.separator") + numOfTrucks + System.getProperty("line.separator");
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Opportunity opportunity = test.createOpportunity(leadId, newContact);
        System.setIn(savedStandardInputStream);
        assertTrue(opportunity.getDecisionMaker() instanceof Contact);
        assertEquals("Stones", opportunity.getDecisionMaker().getCompanyName());
        assertEquals(Product.HYBRID, opportunity.getProduct());
        assertEquals(Status.OPEN, opportunity.getStatus());
        assertEquals(false, DataValidator.leadExists(Long.toString(leadId)));
    }

    @Test
    @DisplayName("Test: createScanner(). Return scanner object as expected.")
    public void CommandHandler_CreateScanner_ScannerCreated() {
        InputStream in = new ByteArrayInputStream("box".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        assertTrue(createScanner() instanceof Scanner);
    }

    @Test
    @DisplayName("Test: createScanner(). Scanner object not returned as invalid input provided.")
    public void CommandHandler_CreateScanner_ScannerNotCreated() {
        InputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        assertEquals(null, createScanner());
    }

    @Test
    @DisplayName("Test: getEnumInput(). Return correct enum value as expected.")
    public void CommandHandler_GetEnumInput_EnumReturned() {
        InputStream in = new ByteArrayInputStream("box".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        assertEquals(Product.BOX, getEnumInput("product"));
    }

    @Test
    @DisplayName("Test: getIntInput(). Return correct int value as expected.")
    public void CommandHandler_GetIntInput_IntReturned() {
        InputStream in = new ByteArrayInputStream("200".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        assertEquals(200, test.getIntInput("quantity"));
    }

    @Test
    @DisplayName("Test: getUserInput(). Return correct String value as expected.")
    public void CommandHandler_GetUserInput_StringReturned() {
        InputStream in = new ByteArrayInputStream("Marion".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        assertEquals("Marion", test.getUserInput());
    }

    @Test
    @DisplayName("Test: setupAccount(). Account created as expected.")
    public void CommandHandler_SetUpAccount_AccountCreated() {
        accountInfoList = Arrays.asList(Industry.PRODUCE, 25, "Boston", "USA");
        newContact = new Contact("Peter Parker", "999888777", "peterP@yahoo.com", "Webs");
        newOpportunity = new Opportunity(Product.FLATBED, 25, newContact);
        assertEquals(Industry.PRODUCE, test.setupAccount(newOpportunity, accountInfoList).getIndustry());
        assertEquals(newOpportunity, test.setupAccount(newOpportunity, accountInfoList).getOpportunityList().get(0));
        assertEquals(newContact, test.setupAccount(newOpportunity, accountInfoList).getContactList().get(0));
    }

    @Test
    void CommandHandler_getIdFromInput_PositiveTest() {

        assertEquals(0, CommandHandler.getIdFromInput("test test"));
        assertEquals(12, CommandHandler.getIdFromInput("test 12"));
        assertEquals(133, CommandHandler.getIdFromInput("test 133         "));
        assertEquals(0, CommandHandler.getIdFromInput("         133 /        "));
        assertEquals(0, CommandHandler.getIdFromInput("test12"));
    }

    @Test
    void CommandHandler_getTextWithoutId_PositiveTest() {
        String text = getTextWithoutId("lookup lead 12");
        String text2 = getTextWithoutId("lookup lead               12");

        assertEquals(text,"lookup lead");
        assertEquals(text2,"lookup lead");
    }

    @Test
    void CommandHandler_updateOpportunityStatusClosedWin_PositiveTest() {
        List<Contact> testContactList = new ArrayList<>();
        Contact testContact = new Contact ("John Smith", "14243434", "johnsmith@gmx.de", "Smith Lab");
        testContactList.add(testContact);

        List<Opportunity> testOpportunityList = new ArrayList<>();
        Opportunity testOpportunity = new Opportunity(Product.BOX, 12, testContact);
        testOpportunityList.add(testOpportunity);

        Account testAccount = new Account(Industry.MANUFACTURING, 345, "New York", "USA", testContactList, testOpportunityList);
        accountList.add(testAccount);

        Long id = testOpportunity.getId();
        updateOpportunityStatusClosedWin(id);
        assertEquals(Status.CLOSED_WON, testOpportunity.getStatus());

        accountList.remove(testAccount);
    }

    @Test
    void CommandHandler_updateOpportunityStatusClosedWin_NegativeTest() {
        List<Contact> testContactList = new ArrayList<>();
        Contact testContact = new Contact ("John Smith", "14243434", "johnsmith@gmx.de", "Smith Lab");
        testContactList.add(testContact);

        List<Opportunity> testOpportunityList = new ArrayList<>();
        Opportunity testOpportunity = new Opportunity(Product.BOX, 12, testContact);
        testOpportunityList.add(testOpportunity);

        Account testAccount = new Account(Industry.MANUFACTURING, 345, "New York", "USA", testContactList, testOpportunityList);
        accountList.add(testAccount);

        Long id = testOpportunity.getId();
        updateOpportunityStatusClosedWin(id);
        assertFalse(Status.OPEN == testOpportunity.getStatus());

        accountList.remove(testAccount);
    }

    @Test
    void updateOpportunityStatusClosedLost_PositiveTest() {
        List<Contact> testContactList = new ArrayList<>();
        Contact testContact = new Contact ("John Smith", "14243434", "johnsmith@gmx.de", "Smith Lab");
        testContactList.add(testContact);

        List<Opportunity> testOpportunityList = new ArrayList<>();
        Opportunity testOpportunity = new Opportunity(Product.BOX, 12, testContact);
        testOpportunityList.add(testOpportunity);

        Account testAccount = new Account(Industry.MANUFACTURING, 345, "New York", "USA", testContactList, testOpportunityList);
        accountList.add(testAccount);

        Long id = testOpportunity.getId();
        updateOpportunityStatusClosedLost(id);
        assertEquals(Status.CLOSED_LOST, testOpportunity.getStatus());

        accountList.remove(testAccount);
    }

    @Test
    void updateOpportunityStatusClosedLost_NegativeTest() {
        List<Contact> testContactList = new ArrayList<>();
        Contact testContact = new Contact ("John Smith", "14243434", "johnsmith@gmx.de", "Smith Lab");
        testContactList.add(testContact);

        List<Opportunity> testOpportunityList = new ArrayList<>();
        Opportunity testOpportunity = new Opportunity(Product.BOX, 12, testContact);
        testOpportunityList.add(testOpportunity);

        Account testAccount = new Account(Industry.MANUFACTURING, 345, "New York", "USA", testContactList, testOpportunityList);
        accountList.add(testAccount);

        Long id = testOpportunity.getId();
        updateOpportunityStatusClosedLost(id);
        assertFalse(Status.OPEN == testOpportunity.getStatus());

        accountList.remove(testAccount);
    }

    @Test
    @DisplayName("Test: voidChecker(). Returns error.")
    public void CommandHandler_VoidCheckerTest_ErrorExpected() {
        Lead testLead = null;
        voidChecker(testLead);
        assertEquals("Please try again.", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    @DisplayName("Test: voidChecker(). Returns expected String value.")
    public void CommandHandler_VoidCheckerTest_CorrectValueExpected() {
        Lead testLead = new Lead("John Smith", "14243434", "johnsmith@gmx.de", "Smith Lab");
        voidChecker(testLead);
        assertEquals(testLead.toString(), outputStreamCaptor.toString()
                .trim());
    }
}
