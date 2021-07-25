package com.ironhack.FabFour.homework2.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ironhack.FabFour.homework2.common.DataValidator.validateEmail;
import static com.ironhack.FabFour.homework2.common.DataValidator.validatePhoneNumber;
import static com.ironhack.FabFour.homework2.common.DataValidator.isEmpty;

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

    /*
    @Test
    @DisplayName("Test: correct phone number with parentheses")
    void validatePhoneNumber_correctNumberWithParentheses() {
        assertTrue(validatePhoneNumber("(030)123456789"));
    }

     */

    @Test
    @DisplayName("Test: correct phone number with spaces")
    void validatePhoneNumber_correctNumberWithSpaces() {
        assertTrue(validatePhoneNumber("123 456 789"));
    }

    /*
    @Test
    @DisplayName("Test: correct phone number with hyphen")
    void validatePhoneNumber_correctNumberWithHyphen() {
        assertTrue(validatePhoneNumber("12-45-67-89"));
    }

     */

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
    void isEmpty_noInput() {
        assertTrue(isEmpty(""));
    }

    @Test
    void isEmpty_withWhiteSpaces() {
        assertTrue(isEmpty("          "));
    }

    @Test
    void isEmpty_containsCharacter() {
        assertFalse(isEmpty("    .      "));
    }
}
