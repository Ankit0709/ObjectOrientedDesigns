package com.ankitkhankriyal.splitwise.model;

public class PercentSplit extends  Split{
    Double percentage;
    public PercentSplit(User user,Double percentage) {
        super(user);
        this.percentage=percentage;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
