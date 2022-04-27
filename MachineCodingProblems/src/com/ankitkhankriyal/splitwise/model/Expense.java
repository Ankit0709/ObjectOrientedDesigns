package com.ankitkhankriyal.splitwise.model;

import java.util.List;

public abstract class Expense {
    private String id;
    private User paidBy;
    private Double amount;
    private List<Split> splits;
    private ExpenseMetaData expenseMetaData;

    public Expense(User paidBy, Double amount, List<Split> splits, ExpenseMetaData expenseMetaData) {
         this.paidBy = paidBy;
        this.amount = amount;
        this.splits = splits;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public ExpenseMetaData getExpenseMetaData() {
        return expenseMetaData;
    }

    public void setExpenseMetaData(ExpenseMetaData expenseMetaData) {
        this.expenseMetaData = expenseMetaData;
    }
    public abstract  boolean validate();
}
