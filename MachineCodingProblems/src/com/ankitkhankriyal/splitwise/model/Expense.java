package com.ankitkhankriyal.splitwise.model;

import java.util.List;

public abstract class Expense {
    private String id;
    private User paidBy;
    private List<Split> splits;
    private double amount;
    private ExpenseMetaData expenseMetaData;

    public Expense(User paidBy, List<Split> splits, double amount, ExpenseMetaData expenseMetaData) {
        this.paidBy = paidBy;
        this.splits = splits;
        this.amount = amount;
        this.expenseMetaData = expenseMetaData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ExpenseMetaData getExpenseMetaData() {
        return expenseMetaData;
    }

    public void setExpenseMetaData(ExpenseMetaData expenseMetaData) {
        this.expenseMetaData = expenseMetaData;
    }
    public abstract  boolean validate();
}
