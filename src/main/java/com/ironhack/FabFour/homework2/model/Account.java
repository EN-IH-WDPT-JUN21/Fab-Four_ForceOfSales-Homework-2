package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.common.CommandHandler;
import com.ironhack.FabFour.homework2.common.EnumHandler;
import com.ironhack.FabFour.homework2.enums.Industry;

import java.util.List;
import java.util.Scanner;

public class Account {
    private static long accountIDCount = 1000;
    private long id;
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private List<Contact> contactList;
    private List<Opportunity> opportunityList;

    public Account(Industry industry,
                   int employeeCount,
                   String city,
                   String country,
                   List<Contact> contactList,
                   List<Opportunity> opportunityList) {
        setId(id);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        setContactList(contactList);
        setOpportunityList(opportunityList);
    }

    public long getId() {
        return Account.accountIDCount;
    }

    public void setId(long id) {
        this.id = accountIDCount;
        accountIDCount++;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        if (industry != null) {
            this.industry  = industry ;
        }
        else {
            setEnum(CommandHandler.createScanner());
        }
    }

    public void setEnum(Scanner sc) {
        setIndustry(EnumHandler.getRequiredIndustry(sc.next()));
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        if (employeeCount > 0) {
            this.employeeCount = employeeCount;
        }
        else {
            setInteger(CommandHandler.createScanner());
        }
    }

    public void setInteger(Scanner sc) {
        setEmployeeCount(Integer.parseInt(sc.next()));
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (!city.isBlank()) {
            this.city = city;
        }
        else {
            setString("city", CommandHandler.createScanner());
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (!country.isBlank()) {
            this.country = city;
        }
        else {
            setString("country", CommandHandler.createScanner());
        }
    }

    public void setString(String attribute, Scanner sc) {
        if(attribute.equals("city")) {
            setCity(sc.next());
        } else if(attribute.equals("country")) {
            setCountry(sc.next());
        }
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && employeeCount == account.employeeCount && industry == account.industry && city.equals(account.city) && country.equals(account.country) && contactList.equals(account.contactList) && opportunityList.equals(account.opportunityList);
    }

    public Opportunity getOpportunity(String id) {
        for(Opportunity opportunity : opportunityList) {
            long temp = opportunity.getId();
            if(Long.parseLong(id) == temp) {
                return opportunity;
            };
        }
        return null;
    }

}

