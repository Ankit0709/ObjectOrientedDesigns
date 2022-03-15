package com.ankitkhankriyal.splitwise.model;

import java.util.List;

public class ExactExpense extends  Expense{

    public ExactExpense(User paidBy, List<Split> splits, double amount, ExpenseMetaData expenseMetaData) {
        super(paidBy, splits, amount, expenseMetaData);
    }

    @Override
    public boolean validate() {
        for(Split split:getSplits()){
            if(!(split instanceof  ExactSplit)){
                return false;
            }
        }
       double splitAmount=0.0;
       double totalAmount=getAmount();
       for(Split split:getSplits()){
           splitAmount+=split.getAmount();
       }
       return splitAmount==totalAmount;
    }
}
