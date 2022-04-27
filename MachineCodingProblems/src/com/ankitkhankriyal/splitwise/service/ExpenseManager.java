package com.ankitkhankriyal.splitwise.service;

import com.ankitkhankriyal.splitwise.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//This service is responsible for talking with the expense service
// It is our main orchestrator
public class ExpenseManager {
    private List<Expense> expenses;
    private Map<String, User> userMap;
    private Map<String,Map<String,Double>> balanceSheet;

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, Map<String, Double>> getBalanceSheet() {
        return balanceSheet;
    }

    public void setBalanceSheet(Map<String, Map<String, Double>> balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    //Adds user in user map and creates balance sheet for that
    public void addUser(User user){
        userMap.put(user.getId(),user);
        balanceSheet.put(user.getId(), new HashMap<>());
    }
    //Add expense in expense list
    public void addExpense(ExpenseType expenseType, User paidBy, Double amount, List<Split> splits, ExpenseMetaData expenseMetaData){
        Expense expense = ExpenseService.createExpense(expenseType, paidBy, amount, splits, expenseMetaData);
        for(Split split: expense.getSplits()){
            String paidTo = split.getUser().getId();

        }

    }


}
