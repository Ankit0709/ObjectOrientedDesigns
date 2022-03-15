package com.ankitkhankriyal.splitwise.model;

import java.util.List;

public class EqualExpense extends  Expense{
    public EqualExpense(User paidBy, List<Split> splits, double amount,ExpenseMetaData expenseMetaData) {
        super(paidBy, splits, amount,expenseMetaData);
    }

    @Override
    public boolean validate() {
        for(Split split:getSplits()){
            if(!(split instanceof  EqualSplit)){
                return false;
            }

        }
        return true;
    }
}
