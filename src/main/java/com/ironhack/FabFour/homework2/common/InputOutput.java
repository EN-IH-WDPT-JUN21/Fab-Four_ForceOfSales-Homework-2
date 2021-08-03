package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class InputOutput {
    // Export Lead Information to CSV
    public static void exportLeadInformation() {
        Scanner aScanner = new Scanner(System.in);
        System.out.println("What would you like to name your file?");
        String fileName = aScanner.nextLine().replaceAll("\\s+", "_");
        BufferedWriter csvWriter = null;
        try {
            csvWriter = new BufferedWriter(new FileWriter(fileName + ".txt"));
            csvWriter.write("Id,Contact Name,Phone Number,Email,Company Name \n");
            for(Lead lead : LeadList.getListOfLeads()) {
                csvWriter.write(lead.getId() + "," + lead.getContactName() + "," + lead.getPhoneNumber() +
                        "," + lead.getEmail() + "," + lead.getCompanyName() + "\n");
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
        finally {
            try {
                csvWriter.flush();
            }
            catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
    }

    // Export Account Information to CSV
    public static void exportAccountInformation() {
        Scanner aScanner = new Scanner(System.in);
        System.out.println("What would you like to name your file?");
        String fileName = aScanner.nextLine().replaceAll("\\s+", "_");
        BufferedWriter csvWriter = null;
        try {
            csvWriter = new BufferedWriter(new FileWriter(fileName + ".txt"));
            csvWriter.write("Id,Industry,Employee Count,City,Country,Number of Opportunities \n");
            for(Account account : AccountList.accountList) {
                csvWriter.write(account.getId() + "," + account.getIndustry() + "," + account.getEmployeeCount() +
                        "," + account.getCity() + "," + account.getCountry() + "," + account.getOpportunityList().size() + "\n");
            }
            csvWriter.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // Export Opportunities Information to CSV
    public static void exportOppInformation() {
        Scanner aScanner = new Scanner(System.in);
        System.out.println("What would you like to name your file?");
        String fileName = aScanner.nextLine().replaceAll("\\s+", "_");
        BufferedWriter csvWriter = null;
        try {
            csvWriter = new BufferedWriter(new FileWriter(fileName + ".txt"));
            csvWriter.write("Company ID,Company Name,Id,Product,Quantity,Decision Maker,Status \n");
            for(Account account : AccountList.accountList) {
                for(Opportunity opp : account.getOpportunityList()) {
                    csvWriter.write(account.getId() + "," + account.getContactList().get(0).getCompanyName() + "," + opp.getId() + "," +
                            opp.getProduct() + "," + opp.getQuantity() + "," + opp.getDecisionMaker() + "," +
                            opp.getStatus() + "\n");
                }
            }
            csvWriter.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
