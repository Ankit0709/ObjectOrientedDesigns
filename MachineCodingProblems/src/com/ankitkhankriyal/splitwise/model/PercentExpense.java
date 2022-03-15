package com.ankitkhankriyal.splitwise.model;

import java.util.List;

public class PercentExpense extends  Expense{

    public PercentExpense(User paidBy, List<Split> splits, double amount, ExpenseMetaData expenseMetaData) {
        super(paidBy, splits, amount, expenseMetaData);
    }

    @Override
    public boolean validate() {
        for(Split split:getSplits()){
            if(!(split instanceof  PercentSplit)){
                return false;
            }
        }
        double totalPercent = 100;
        double percent=0;
        for(Split split : getSplits()){
            PercentSplit percentSplit = (PercentSplit) split;
            percent += percentSplit.getPercentage();
        }
        return percent==totalPercent;
    }
}
