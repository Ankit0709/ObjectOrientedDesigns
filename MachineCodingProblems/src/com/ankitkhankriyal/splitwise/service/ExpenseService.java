package com.ankitkhankriyal.splitwise.service;

import com.ankitkhankriyal.splitwise.model.*;

import java.util.List;

//This class is responsible to create Expense object based on expense type
public class ExpenseService {
    public static Expense createExpense(ExpenseType expenseType, User paidBy, Double amount, List<Split> splits, ExpenseMetaData expenseMetaData){
        switch (expenseType){
            case EXACT:
                return new ExactExpense(paidBy,amount,splits,expenseMetaData);
            case  PERCENTAGE:
                for(Split split:splits){
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount((percentSplit.getPercentage()*amount)/100.00);
                }
                return new PercentExpense(paidBy,amount,splits,expenseMetaData);
            case EQUAL:
                int totalSplits = splits.size();
                for(Split split:splits) {
                    split.setAmount((double) Math.round((amount*100/totalSplits)/100.00));
                }
                return new EqualExpense(paidBy, amount, splits, expenseMetaData);
            default:
                return null;
        }
    }
}
