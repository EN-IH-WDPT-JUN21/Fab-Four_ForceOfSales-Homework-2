package com.ironhack.FabFour.homework2.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeadListTest {

    private static Lead testOne = null;
    private static Lead testTwo = null;


    @BeforeAll
    public static void setUp() {
        testOne = new Lead("Buzz","0808","buzz@lightyear","A Company");
        testTwo = new Lead("Woody","0808","woody@pixar","A Company");
    }

    @Test
    @DisplayName("Test: countLeads(). Return the correct amount of leads")
    public void LeadList_CountLeadsTest_ReturnCountOfLeads() {
        int currentListCount = LeadList.getListOfLeads().size();
        LeadList.getListOfLeads().add(testOne);
        int updatedListCount = LeadList.getListOfLeads().size();
        assertTrue(updatedListCount == currentListCount + 1);
    }

//    @Test
//    @DisplayName("Test: showLeads(). Return the lead information as expected.")
//    public void LeadList_ShowLeadsTest_ReturnLeadInfo() {
//
//    }
}
