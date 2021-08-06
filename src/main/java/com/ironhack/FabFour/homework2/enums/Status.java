package com.ironhack.FabFour.homework2.enums;

public enum Status {
    OPEN("OPEN"),
    CLOSED_WON("CLOSED-WON"),
    CLOSED_LOST("CLOSED-LOST");

    public final String statusType;

    Status(String statusType) {
        this.statusType = statusType;
    }

    public static Status getStatus(String statusType) {
        for (Status status : values()) {
            if (status.statusType.equals(statusType.toUpperCase()))
                return status;
        }
        return null;
    }
}
