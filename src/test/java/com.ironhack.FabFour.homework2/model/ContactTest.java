package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.common.Contact;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {

    public static Contact testContactOne = null;
    public static Contact testContactTwo = null;

    @BeforeAll
    public static void setUp() {
        testContactOne = new Contact("Marie","0000 1234","marie@email.com","A New Company");
        testContactTwo = new Contact("Barry", "1234 5678", "barry@test.com","Another Company");
    }

    @Test
    @DisplayName("Test: Contact Constructor. Expected Values Returned.")
    public void ContactTest_ContactConstructor_ValuesExpected() {
        assertEquals(1,testContactOne.getId());
        assertEquals("Marie",testContactOne.getContactName());
        assertEquals("0000 1234",testContactOne.getPhoneNumber());
        assertEquals("marie@email.com",testContactOne.getEmail());
        assertEquals("A New Company",testContactOne.getCompanyName());

        assertEquals(2,testContactTwo.getId());
        assertEquals("Barry",testContactTwo.getContactName());
        assertEquals("1234 5678",testContactTwo.getPhoneNumber());
        assertEquals("barry@test.com",testContactTwo.getEmail());
        assertEquals("Another Company",testContactTwo.getCompanyName());
    }
}
