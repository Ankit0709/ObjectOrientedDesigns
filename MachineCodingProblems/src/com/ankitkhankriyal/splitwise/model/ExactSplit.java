package com.ankitkhankriyal.splitwise.model;

public class ExactSplit extends  Split{
    public ExactSplit(User user,Double amount) {
        super(user);
        this.amount=amount;
    }
}
