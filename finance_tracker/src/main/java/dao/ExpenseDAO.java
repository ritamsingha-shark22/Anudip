package dao;

import model.Expense;
import java.util.List;

public interface ExpenseDAO {
    void addExpense(Expense expense);
    void updateExpense(Expense expense);
    void deleteExpense(int expenseId);
    List<Expense> getAllExpenses();
    Expense getExpenseById(int expenseId);
}

