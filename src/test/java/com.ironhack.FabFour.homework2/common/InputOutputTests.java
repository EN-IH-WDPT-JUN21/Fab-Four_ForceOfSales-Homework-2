package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Industry;
import com.ironhack.FabFour.homework2.model.*;
import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.ironhack.FabFour.homework2.enums.Product.BOX;
import static com.ironhack.FabFour.homework2.enums.Product.HYBRID;

public class InputOutputTests {

    static List<Lead> tempLeadList = new ArrayList<>();
    static List<Account> tempAccountList = new ArrayList<>();

    @BeforeAll
    public static void setup() throws IOException {
        tempLeadList = LeadList.getListOfLeads();
        LeadList.getListOfLeads().clear();
        LeadList.getListOfLeads().add(new Lead("Test One","02030104","test@one.com","A test company"));
        LeadList.getListOfLeads().add(new Lead("Test Two","09080706","test@two.com","A test company"));
        LeadList.getListOfLeads().add(new Lead("Test Three","11111111","test@three.com","A test company"));
        tempAccountList = AccountList.accountList;
        AccountList.accountList.clear();
        AccountList.accountList.add(new Account(Industry.OTHER,50,"Berlin","Germany",new ArrayList<>(),new ArrayList<>()));
        AccountList.accountList.add(new Account(Industry.MEDICAL,300,"London","UK",new ArrayList<>(),new ArrayList<>()));
        AccountList.accountList.get(0).getOpportunityList().add(new Opportunity(BOX,50,new
                Contact("Contact One","02030104","contact@one.com","A test company")));
        AccountList.accountList.get(1).getOpportunityList().add(new Opportunity(HYBRID,50,new
                Contact("Contact One","02030104","contact@one.com","A test company")));
    }

    @AfterAll
    public static void tearDown() {
        LeadList.setListOfLeads(tempLeadList);
        AccountList.accountList = tempAccountList;
    }

    @Test
    @DisplayName("Test: exportLeadInformation(). Verify that export is the same each time.")
    public void InputOutput_ExportLeadInformationTest_SameExport() throws IOException {
        String simulatedInput = "LeadTestOne";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        InputOutput.exportLeadInformation();
        System.setIn(savedStandardInputStream);

    }
}
