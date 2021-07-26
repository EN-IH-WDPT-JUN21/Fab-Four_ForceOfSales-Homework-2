package com.ironhack.FabFour.homework2.model;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class LeadListTest {

    private static Lead testOne = null;
    private static Lead testTwo = null;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeAll
    public static void setUp() {
        testOne = new Lead("Buzz","0808","buzz@lightyear","A Company");
        testTwo = new Lead("Woody","0808","woody@pixar","A Company");
    }

    @BeforeEach
    public void secondSetUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Test: countLeads(). Add Lead.")
    public void LeadList_CountLeadsTest_AddLead() {
        int currentListCount = LeadList.countLeads();
        LeadList.getListOfLeads().add(testOne);
        int updatedListCount = LeadList.countLeads();
        assertTrue(updatedListCount == currentListCount + 1);
    }

    @Test
    @DisplayName("Test: countLeads(). Remove Lead.")
    public void LeadList_CountLeadsTest_RemoveLead() {
        LeadList.getListOfLeads().add(testOne);
        int currentListCount = LeadList.countLeads();
        LeadList.getListOfLeads().remove(testOne);
        int updatedListCount = LeadList.countLeads();
        assertTrue(updatedListCount == currentListCount - 1);
    }


    @Test
    @DisplayName("Test: showLeads(). Return the lead information as expected.")
    public void LeadList_ShowLeadsTest_ReturnLeadInfo() {
        LeadList.getListOfLeads().clear();
        LeadList.getListOfLeads().add(testOne);
        LeadList.showLeads();

        assertEquals("Lead ID: " + testOne.getId() + ", Contact Name: Buzz.", outputStreamCaptor.toString()
                .trim());
    }
}
