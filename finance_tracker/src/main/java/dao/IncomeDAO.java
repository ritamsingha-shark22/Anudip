package dao;

import model.Income;
import java.util.List;

public interface IncomeDAO {
    void addIncome(Income income);
    void updateIncome(Income income);
    void deleteIncome(int incomeId);
    List<Income> getAllIncomes();
    Income getIncomeById(int incomeId);
}

