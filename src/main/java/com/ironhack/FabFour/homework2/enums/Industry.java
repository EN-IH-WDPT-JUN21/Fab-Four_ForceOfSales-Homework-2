package com.ironhack.FabFour.homework2.enums;

public enum Industry {
    PRODUCE("PRODUCE"),
    ECOMMERCE("ECOMMERCE"),
    MANUFACTURING("MANUFACTURING"),
    MEDICAL("MEDICAL"),
    OTHER("OTHER");

    public final String industryType;

    Industry(String industryType) {
        this.industryType = industryType;
    }

    public static Industry getIndustry(String industryType) {
        for (Industry industry : values()) {
            if (industry.industryType.equals(industryType.toUpperCase()))
                return industry;
        }
        return null;
    }
}
