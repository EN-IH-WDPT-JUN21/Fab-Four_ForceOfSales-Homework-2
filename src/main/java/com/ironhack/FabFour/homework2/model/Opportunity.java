package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.common.CommandHandler;
import com.ironhack.FabFour.homework2.enums.Product;
import com.ironhack.FabFour.homework2.enums.Status;
import com.ironhack.FabFour.homework2.common.EnumHandler;

import java.util.Scanner;


public class Opportunity {
    private static long opportunityIDCount = 1000;
    private long id;
    private Product product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;

    public Opportunity(Product product, int quantity, Contact decisionMaker) {
        setId(id);
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(Status.OPEN);
    }

    public long getId() {
        return Opportunity.opportunityIDCount;
    }

    public void setId(long id) {
        this.id = opportunityIDCount;
        opportunityIDCount++;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (product != null) {
            this.product = product;
        }
        else {
            setEnum(CommandHandler.createScanner());
        }
    }

    public void setEnum(Scanner sc) {
        setProduct(EnumHandler.getRequiredProduct(sc.next()));
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0 && quantity <= 300) {
            this.quantity = quantity;
        }
        else {
            setInteger(CommandHandler.createScanner());
        }
    }

    public void setInteger(Scanner sc) {
        setQuantity(Integer.parseInt(sc.next()));
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status != null && (status == Status.CLOSED_LOST || status == Status.CLOSED_WON)) {
            this.status = status;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opportunity that = (Opportunity) o;
        return id == that.id && quantity == that.quantity && product == that.product && decisionMaker.equals(that.decisionMaker) && status == that.status;
    }
}
