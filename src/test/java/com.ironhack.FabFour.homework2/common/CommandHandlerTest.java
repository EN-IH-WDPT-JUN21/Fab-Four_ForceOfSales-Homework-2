package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Status;
import com.ironhack.FabFour.homework2.model.Account;
import com.ironhack.FabFour.homework2.model.Contact;
import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.Opportunity;

import static com.ironhack.FabFour.homework2.common.CommandHandler.createScanner;
import static org.junit.jupiter.api.Assertions.*;
import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.LeadList;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class CommandHandlerTest {

    CommandHandler test;
    Lead tempLeadOne = null;
    Account newAccount;
    Opportunity newOpportunity;

    @BeforeEach
    public void setUp() {
        test = new CommandHandler();
    }


//    @Test
//    @DisplayName("Test: createLead(). Validate that newly created lead is added to LeadList.")
//    public void CommandHandler_CreateLeadTest_ValidateLeadAddedToList() {
//        var currentListSize = LeadList.getListOfLeads().size();
////        test.createLead();
//        assertTrue(LeadList.getListOfLeads().size() == currentListSize + 1);
//    }

    @Test
    @DisplayName("Test: lookupLead(). Return the lead as expected.")
    public void CommandHandler_LookupLead_LeadReturned() {
        tempLeadOne = new Lead("Buzz","0800","buzz@lightyear","Toy Story");
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
        tempLeadOne = new Lead("Buzz","0800","buzz@lightyear","Toy Story");
        LeadList.getListOfLeads().add(tempLeadOne);
        int currentListSize = LeadList.getListOfLeads().size();
        test.removeLead(1);
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
    @DisplayName("Test: createScanner(). Return scanner object as expected.")
    public void CommandHandler_CreateScanner_ScannerCreated(){
        assertTrue(createScanner() instanceof Scanner);
    }

    @Test
    @DisplayName("Test: convertLead(). Lead converted as expected.")
    public void CommandHandler_ConvertLead_LeadConverted(){
        InputStream in = new ByteArrayInputStream("anna".getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        Lead tempLeadOne = test.createLead();
        long tempId = tempLeadOne.getId();
//        String leadName = tempLeadOne.getContactName();
//        String leadPhone = tempLeadOne.getPhoneNumber();
//        String leadEmail = tempLeadOne.getEmail();
//        Account newAccount = test.convertLead(tempId);
//        assertEquals(leadName, newAccount.getContactList().get(0).getContactName());
//        assertEquals(leadPhone, newAccount.getContactList().get(0).getPhoneNumber());
//        assertEquals(leadEmail, newAccount.getContactList().get(0).getEmail());
    }

    @Test
    @DisplayName("Test: setupAccount(). Account created as expected.")
    public void CommandHandler_SetUpAccount_AccountCreated(){

    }



}
