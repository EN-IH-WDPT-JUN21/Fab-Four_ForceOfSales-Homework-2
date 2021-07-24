package com.ironhack.FabFour.homework2.common;

import com.ironhack.FabFour.homework2.enums.Product;
import com.ironhack.FabFour.homework2.enums.Industry;
import com.ironhack.FabFour.homework2.enums.Status;

public class EnumHandler {

    public static Product getRequiredProduct(String productString) {
        Product product = null;
        switch (productString.toUpperCase()) {
            case "FLATBED":
                product = Product.FLATBED;
                break;
            case "HYBRID":
                product = Product.HYBRID;
                break;
            case "BOX":
                product = Product.BOX;
                break;
        }
        return product;
    }

    public static Industry getRequiredIndustry(String industryString) {
        Industry industry = null;
        switch (industryString.toUpperCase()) {
            case "PRODUCE":
                industry = industry.PRODUCE;
                break;
            case "ECOMMERCE":
                industry = industry.ECOMMERCE;
                break;
            case "MANUFACTURING":
                industry = industry.MANUFACTURING;
                break;
            case "MEDICAL":
                industry = industry.MEDICAL;
                break;
            case "OTHER":
                industry = industry.OTHER;
                break;
        }
        return industry;
    }

}
