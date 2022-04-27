package com.ankitkhankriyal.splitwise.model;

import java.util.List;

public class PercentExpense  extends  Expense{
    public PercentExpense( User paidBy, Double amount, List<Split> splits, ExpenseMetaData expenseMetaData) {
        super(paidBy, amount, splits, expenseMetaData);
    }

    @Override
    public boolean validate() {
        for(Split split:getSplits()){
            if(!(split instanceof  PercentSplit)){
                return false;
            }
        }
        Double totalPer=100.00;
        Double percent=0.0;
        for(Split split:getSplits()) {
            PercentSplit percentSplit = (PercentSplit) split;
            percent+=percentSplit.getPercentage();
        }
        return percent==totalPer;
    }
}
