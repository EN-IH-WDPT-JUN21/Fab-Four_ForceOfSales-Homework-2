package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Status;
import com.ironhack.FabFour.homework2.model.Account;
import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.LeadList;
import com.ironhack.FabFour.homework2.model.Opportunity;

import java.util.List;

public class CommandHandler {
    //public?
    public static List<Account> accountList;

    public void handleCommand(String command) {}
    public Lead createLead() {return null;}
    public Lead lookupLead(long id) {return null;}
    public void removeLead(long id) {}
    public Opportunity convertLead(long id) { return null;}

    public void updateOpportunityStatusClosedLost(long id) {
        for(Account account : accountList) {
            Opportunity opportunity = account.getOpportunity(String.valueOf(id));
            if(opportunity != null) {
                opportunity.setStatus(Status.CLOSED_LOST);
            }
        }
    }

    public void updateOpportunityStatusClosedWin(long id) {
        for(Account account : accountList) {
            Opportunity opportunity = account.getOpportunity(String.valueOf(id));
            if(opportunity != null) {
                opportunity.setStatus(Status.CLOSED_WON);
            }
        }
    }

    public void IOHandler(){}
}
