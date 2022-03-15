package com.ankitkhankriyal.splitwise.model;

public class PercentSplit extends  Split{
    double percentage;
    public PercentSplit(User user,double percentage) {
        super(user);
        this.percentage=percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
