package com.ironhack.FabFour.homework2.model;

import com.ironhack.FabFour.homework2.enums.Product;
import com.ironhack.FabFour.homework2.enums.Status;

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
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

//    public void setStatus(Status status) {
//        Status currentStatus = this.status;
//        if(currentStatus == Status.CLOSED_LOST || currentStatus == Status.CLOSED_WON && status == Status.OPEN) {
//            this.status = currentStatus;
//        } else {
//            this.status = status;
//        }
//        if (currentStatus == Status.OPEN && status == Status.CLOSED_LOST || status == Status.CLOSED_WON) {
//            this.status = status;
//        }
//    }

 public void setStatus(Status status) {
        Status currentStatus = this.status;
        if(currentStatus == Status.CLOSED_LOST || currentStatus == Status.CLOSED_WON && status == Status.OPEN) {
            this.status = currentStatus;
        } else {
            if(status == Status.OPEN || status == Status.CLOSED_LOST || status == Status.CLOSED_WON) {
                this.status = status;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opportunity that = (Opportunity) o;
        return quantity == that.quantity && product == that.product && decisionMaker.equals(that.decisionMaker) && status == that.status;
    }

    @Override
    public String toString() {
        return "Opportunity: " + this.getId() + ", Product: " + this.getProduct() + ", Quantity: " +
                this.getQuantity() + ", Contact: " + this.getDecisionMaker().getContactName() + ", Status: " + this.getStatus();
    }
}
