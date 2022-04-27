package com.ankitkhankriyal.splitwise.model;

import java.util.List;

public class EqualExpense extends  Expense{
    public EqualExpense(User paidBy, Double amount, List<Split> splits, ExpenseMetaData expenseMetaData) {
        super(paidBy, amount, splits, expenseMetaData);
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
