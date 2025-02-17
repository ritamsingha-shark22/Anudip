package daoimpl;

import dao.IncomeDAO;
import dao.DBConnection;
import model.Income;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAOImpl implements IncomeDAO {

    @Override
    public void addIncome(Income income) {
        String query = "INSERT INTO income (amount, date, description, category_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, income.getAmount());
            stmt.setDate(2, Date.valueOf(income.getDate()));
            stmt.setString(3, income.getDescription());
            stmt.setInt(4, income.getCategoryId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateIncome(Income income) {
        String query = "UPDATE income SET amount = ?, date = ?, description = ?, category_id = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, income.getAmount());
            stmt.setDate(2, Date.valueOf(income.getDate()));
            stmt.setString(3, income.getDescription());
            stmt.setInt(4, income.getCategoryId());
           
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteIncome(int incomeId) {
        String query = "DELETE FROM income WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, incomeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Income> getAllIncomes() {
        String query = "SELECT * FROM income";
        List<Income> incomes = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                incomes.add(new Income(
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
        return incomes;
    }

    @Override
    public Income getIncomeById(int incomeId) {
        String query = "SELECT * FROM income WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, incomeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Income(
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

