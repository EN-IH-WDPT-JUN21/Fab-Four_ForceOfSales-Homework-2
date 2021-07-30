package com.ironhack.FabFour.homework2.enums;

public enum Command {
    NEW_LEAD("NEW LEAD"),
    SHOW_LEADS("SHOW LEADS"),
    LOOKUP_LEAD("LOOKUP LEAD"),
    LOOKUP_OPPORTUNITY("LOOKUP OPPORTUNITY"),
    LOOKUP_ACCOUNT("LOOKUP ACCOUNT"),
    CONVERT("CONVERT"),
    CLOSE_WON("CLOSE-WON"),
    CLOSE_LOST("CLOSE-LOST"),
    HELP("HELP"),
    NONE("");


    public final String value;

    private Command(String value) {
        this.value=value;
    }

    public static Command getCommandType(String sValue) {
        for (Command command: values()) {
            if(command.value.equals(sValue))
                return command;
        }
        return Command.NONE;
    }
}
