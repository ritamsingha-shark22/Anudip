package daoimpl;

import dao.ExpenseDAO;
import dao.DBConnection;
import model.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAOImpl implements ExpenseDAO {

    @Override
    public void addExpense(Expense expense) {
        String query = "INSERT INTO expense (amount, date, description, category_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, expense.getAmount());
            stmt.setDate(2, Date.valueOf(expense.getDate()));
            stmt.setString(3, expense.getDescription());
            stmt.setInt(4, expense.getCategoryId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateExpense(Expense expense) {
        String query = "UPDATE expense SET amount = ?, date = ?, description = ?, category_id = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, expense.getAmount());
            stmt.setDate(2, Date.valueOf(expense.getDate()));
            stmt.setString(3, expense.getDescription());
            stmt.setInt(4, expense.getCategoryId());
            stmt.setInt(5, expense.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteExpense(int expenseId) {
        String query = "DELETE FROM expense WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, expenseId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Expense> getAllExpenses() {
        String query = "SELECT * FROM expense";
        List<Expense> expenses = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                expenses.add(new Expense(
                    rs.getInt("id"),
                    rs.getDouble("amount"),
                    rs.getDate("date").toLocalDate(),
                    rs.getString("description"),
                    rs.getInt("category_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public Expense getExpenseById(int expenseId) {
        String query = "SELECT * FROM expense WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, expenseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Expense(
                    rs.getInt("id"),
                    rs.getDouble("amount"),
                    rs.getDate("date").toLocalDate(),
                    rs.getString("description"),
                    rs.getInt("category_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

