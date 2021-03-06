package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.enums.Industry;

import java.util.List;

public class Account {
    private static long accountIDCount = 2000;
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
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        return employeeCount == account.employeeCount && industry == account.industry && city.equals(account.city) && country.equals(account.country) && contactList.equals(account.contactList) && opportunityList.equals(account.opportunityList);
    }

    public Opportunity getOpportunity(String id) {
        for(Opportunity opportunity : opportunityList) {
            long temp = opportunity.getId();
            if(Long.parseLong(id) == temp) {
                return opportunity;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Account: " + this.getId() + ", Industry: " + this.getIndustry() + ", Number of employees: " +
                this.getEmployeeCount() + ", City: " + this.getCity() + ", Country: " + this.getCountry() +
                ", Contact: " + this.getContactList().get(0).getContactName() + ", Company: " + this.getContactList().get(0).getCompanyName() +
                ", Opportunity ID:" + this.getOpportunityList().get(0).getId();
    }
}

