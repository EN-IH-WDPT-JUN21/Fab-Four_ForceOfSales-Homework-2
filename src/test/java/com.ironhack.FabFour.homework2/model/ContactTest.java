package com.ironhack.FabFour.homework2.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactTest {

    private static Contact testContactOne = null;
    private static Contact testContactTwo = null;

    @BeforeAll
    public static void setUp() {
        testContactOne = new Contact("Marie","01234 5678","marie@email.com","A New Company");
        testContactTwo = new Contact("Barry", "07949 2222", "barry@test.com","Another Company");
    }

    @Test
    @DisplayName("Test: Contact Constructor. Validate ID Set.")
    public void ContactClass_ContactConstructor_CheckCorrectID() {
        long currentID = Contact.getContactIDCount();
        testContactTwo = new Contact("Rick","07949 2222","rick@westley.com","Zombies");
        long updatedID = Contact.getContactIDCount();
        assertTrue(updatedID == (currentID + 1));
    }

    @Test
    @DisplayName("Test: Contact Constructor. Contact Name Set as expected.")
    public void ContactTest_ContactNameTest_SetAsExpected() {
        assertEquals("Marie",testContactOne.getContactName());
    }

    @Test
    @DisplayName("Test: Contact Constructor. Phone Number Set as expected.")
    public void ContactTest_PhoneNumberTest_SetAsExpected() {
        assertEquals("01234 5678",testContactOne.getPhoneNumber());
    }

    @Test
    @DisplayName("Test: Contact Constructor. Email Set as expected.")
    public void ContactTest_EmailTest_SetAsExpected() {
        assertEquals("marie@email.com",testContactOne.getEmail());
    }

    @Test
    @DisplayName("Test: Contact Constructor. Company Name Set as expected.")
    public void ContactTest_CompanyNameTest_SetAsExpected() {
        assertEquals("A New Company",testContactOne.getCompanyName());
    }
}
