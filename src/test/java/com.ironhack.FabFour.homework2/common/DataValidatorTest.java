package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Industry;
import com.ironhack.FabFour.homework2.enums.Product;
import com.ironhack.FabFour.homework2.model.Account;
import com.ironhack.FabFour.homework2.model.Contact;
import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.Opportunity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.ironhack.FabFour.homework2.common.CommandHandler.accountList;
import static com.ironhack.FabFour.homework2.common.DataValidator.*;
import static com.ironhack.FabFour.homework2.model.LeadList.getListOfLeads;
import static org.junit.jupiter.api.Assertions.*;

public class DataValidatorTest {
    /*
    TESTS FOR E-MAIL ADDRESS
     */
    @Test
    @DisplayName("Test: Correct e-mail address")
    void validateEmail_correctEmailAddress() {
        assertTrue(validateEmail("hello@gmail.com"));
    }

    @Test
    @DisplayName("Test: Correct e-mail address with points, numbers and hyphen")
    void validateEmail_correctEmailAddressWithSymbols() {
        assertTrue(validateEmail("h3.l_l0@gmail.com"));
    }

    @Test
    @DisplayName("Test: Wrong e-mail address with double @")
    void validateEmail_falseEmailAddressDoubleSign() {
        assertFalse(validateEmail("hello@@gmail.com"));
    }

    @Test
    @DisplayName("Test: Wrong e-mail address with double points")
    void validateEmail_falseEmailAddressDoublePoints() {
        assertFalse(validateEmail("hello@gmail..com"));
    }

    @Test
    @DisplayName("Test: Wrong e-mail address with half of e-mail missing")
    void validateEmail_falseEmailAddressHalfMissing() {
        assertFalse(validateEmail("hello@"));
    }

    @Test
    @DisplayName("Test: Wrong e-mail address with end of e-mail missing")
    void validateEmail_falseEmailAddressEndMissing() {
        assertFalse(validateEmail("hello@gmail"));
    }

    @Test
    @DisplayName("Test: Empty e-mail address")
    void validateEmail_falseEmailAddressEmpty() {
        assertFalse(validateEmail(" "));
    }

    @Test
    @DisplayName("Test: E-Mail address with white spaces")
    void validateEmail_falseEmailAddressWhiteSpaces() {
        assertFalse(validateEmail("hel lo@gmail.com"));
    }


    /*
        TESTS FOR TELEPHONE NUMBER
     */
    @Test
    @DisplayName("Test: correct phone number")
    void validatePhoneNumber_correctNumber() {
        assertTrue(validatePhoneNumber("123456789"));
    }

    @Test
    @DisplayName("Test: correct phone number with country code")
    void validatePhoneNumber_correctNumberWithCountryCode() {
        assertTrue(validatePhoneNumber("+49123456789"));
    }

    @Test
    @DisplayName("Test: correct phone number with spaces")
    void validatePhoneNumber_correctNumberWithSpaces() {
        assertTrue(validatePhoneNumber("123 456 789"));
    }

    @Test
    @DisplayName("Test: Empty phone number")
    void validatePhoneNumber_wrongNumberEmpty() {
        assertFalse(validatePhoneNumber("123"));
    }

    @Test
    @DisplayName("Test: phone number too short")
    void validatePhoneNumber_wrongNumberTooShort() {
        assertFalse(validatePhoneNumber("123"));
    }

    @Test
    @DisplayName("Test: phone number too long")
    void validatePhoneNumber_wrongNumberTooLong() {
        assertFalse(validatePhoneNumber("01234567891234567"));
    }

    @Test
    @DisplayName("Test: phone number contains letters")
    void validatePhoneNumber_wrongNumberWithLetters() {
        assertFalse(validatePhoneNumber("123a45678"));
    }

    @Test
    @DisplayName("Test: phone number contains other symbol")
    void validatePhoneNumber_wrongNumberWithSymbols() {
        assertFalse(validatePhoneNumber("123!=45678"));
    }

    /*
    TESTS FOR EMPTY CHECK
     */
    @Test
    @DisplayName("Test: input doesn't have any signs")
    void isEmpty_noInput() {
        assertTrue(isEmpty(""));
    }

    @Test
    @DisplayName("Test: input only contains white spaces")
    void isEmpty_withWhiteSpaces() {
        assertTrue(isEmpty("          "));
    }

    @Test
    @DisplayName("Test: input only contains white spaces and a sign")
    void isEmpty_containsCharacter() {
        assertFalse(isEmpty("    .      "));
    }


    /*
    TESTS TO CHECK EXISTENCE
     */

    //TODO: Test needs to be checked, only works individually
    @Test
    @DisplayName("Test: Lead exists")
    void leadExists_IdExists() {
        List<Lead> testListOfLeads = getListOfLeads();
        Lead testLead = new Lead("Peter", "987654321", "peter@email.de", "Small Company");
        testListOfLeads.add(testLead);
        assertTrue(leadExists("1"));
    }

    @Test
    @DisplayName("Test: Lead does not exist")
    void leadExists_IdDoesNotExist() {
        List<Lead> testListOfLeads2 = getListOfLeads();
        Lead testLead = new Lead("Pablo", "123456789", "pablo@email.es", "Big Company");
        testListOfLeads2.add(testLead);
        assertFalse(leadExists("4"));
    }

    //TODO: Test works only individually
    /*
    @Test
    @DisplayName("Test: Opportunity exists")
    void opportunityExists_IdExists() {
        List<Contact> testContactList2 = new ArrayList<Contact>();
        Contact testContact2 = new Contact("Rick","0208","rick@westley","Zombies");
        testContactList2.add(testContact2);

        List<Opportunity> testOpportunityList2 = new ArrayList<Opportunity>();
        Opportunity testOpportunity2 = new Opportunity(Product.HYBRID, 3, testContact2);
        testOpportunityList2.add(testOpportunity2);

        Account testAccount2 = new Account(Industry.ECOMMERCE, 2, "Berlin", "Germany", testContactList2, testOpportunityList2);
        accountList.add(testAccount2);

        assertTrue(opportunityExists("1001"));
    }

     */

    @Test
    @DisplayName("Test: Opportunity does not exist")
    void opportunityExists_wrong() {
        List<Contact> testContactList = new ArrayList<Contact>();
        Contact testContact = new Contact("Nick","1234567","nick@yahoo.fr","Company Zero");
        testContactList.add(testContact);

        List<Opportunity> testOpportunityList = new ArrayList<Opportunity>();
        Opportunity testOpportunity = new Opportunity(Product.HYBRID, 3, testContact);
        testOpportunityList.add(testOpportunity);

        Account testAccount = new Account(Industry.ECOMMERCE, 2, "Berlin", "Germany", testContactList, testOpportunityList);
        accountList.add(testAccount);

        assertFalse(opportunityExists("1234"));
    }

    //TODO: Will be done as soon as equals-methods are tests
    /*
    @Test
    void isDuplicateLead_correct() {
        Contact testContact1 = new Contact("Nick","1234567","nick@yahoo.fr","Company Zero");
        Contact testContact2 = new Contact("Nick","1234567","nick@yahoo.fr","Company Zero");
        List<Lead> testLeadOfLists = new ArrayList<>();
        testLeadOfLists.add(testContact1);
        testLeadOfLists.add(testContact2);

        assertTrue(isDuplicateLead(testContact1));
    }

    @Test
    void isDuplicateOpportunity() {
    }

     */

}
