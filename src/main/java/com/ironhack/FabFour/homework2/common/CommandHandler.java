package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Command;
import com.ironhack.FabFour.homework2.enums.Status;
import com.ironhack.FabFour.homework2.model.Lead;
import com.ironhack.FabFour.homework2.model.LeadList;
import com.ironhack.FabFour.homework2.model.Opportunity;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class CommandHandler {
    public static void handleCommand(String command) {
        String upperCommand = command.trim().toUpperCase(); // delete all spaces around command
        String defaultInfo = "Command not recognised. Type HELP or try again!"; //default info message
        long id = getIdFromInput(upperCommand); // get id from the end of command - if there is no long value then method returns 0;

        if(id<1) { // case when command hasn't any id at the end
            switch(Command.getCommandType(upperCommand)) {
                case NEW_LEAD:
                    createLead();
                    break;
                case SHOW_LEADS:
                    showLeads();
                    break;
                case HELP:
                    System.out.println("--------------------------------------------------\n" +
                            " Type one of below statement to execute :\n" +
                            " > new lead - " + "to create new lead\n" +
                            " > show leads - to show all of leads\n" +
                            " > lookup lead {id} - to show specific lead\n" +
                            " > convert {id} - to convert lead to an opportunity\n" +
                            " > close-win {id} - to close case after sale\n" +
                            " > close-lost {id} - to  close case without sale\n" +
                            "--------------------------------------------------"
                    );
                    break;
                default:
                    System.out.println(defaultInfo);
            }
        } else { // case when command has an id at the end

            upperCommand = upperCommand.substring(0,upperCommand.length()-String.valueOf(id).length()).trim();

            switch(Command.getCommandType(upperCommand)) {
                case CONVERT:
                    convertLead(id);
                    break;
                case LOOKUP_LEAD:
                    lookupLead(id);
                    break;
                case CLOSE_WON:
                    updateOpportunityStatus(id,Status.CLOSED_WON);
                    break;
                case CLOSE_LOST:
                    updateOpportunityStatus(id,Status.CLOSED_LOST);
                    break;
                default:
                    System.out.println(defaultInfo);
            }
        }
    }

    public static long getIdFromInput(String command) {
        String[] words = command.trim().split("\\s");

        try {
            return Long.parseLong(words[words.length-1]);
        } catch(NumberFormatException ignored) {
        }
        return 0; // It returns 0 because you cannot to create id less than 0
    }



    public static List<Lead> showLeads() {return null;}
    public static Lead createLead() {return null;}
    public static Lead lookupLead(long id) {return null;}
    public void removeLead(long id) {}
    public static Opportunity convertLead(long id) { return null;}
    public static void updateOpportunityStatus(long id, Status status) {
        //added Status to method parameters - there is two ways when we can invoke the method - close-won and close-lost
    }
    public void IOHandler(){}
}
