package com.ankitkhankriyal.splitwise.model;

import java.util.List;

public class ExactExpense extends  Expense{
    public ExactExpense(User paidBy, Double amount, List<Split> splits, ExpenseMetaData expenseMetaData) {
        super(paidBy, amount, splits, expenseMetaData);
    }

    @Override
    public boolean validate() {
        Double totalAmount =0.0;
        for(Split split:getSplits()){
            if(!(split instanceof ExactSplit)){
                return false;
            }

        }
        for(Split split:getSplits()){
            totalAmount+=split.getAmount();
        }
        return totalAmount==getAmount();
    }
}
