package model;

import java.time.LocalDate;

public class Income {
    private int id; // Primary key
    private double amount;
    private LocalDate date;
    private String description;
    private int categoryId; // Foreign key from Category

    // Constructor for creating a new income
    public Income(double amount, LocalDate date, String description, int categoryId) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.categoryId = categoryId;
    }

    // Constructor for retrieving from the database (with ID)
    public Income(int id, double amount, LocalDate date, String description, int categoryId) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.categoryId = categoryId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Income [id=" + id + ", amount=" + amount + ", date=" + date + ", description=" + description + ", categoryId=" + categoryId + "]";
    }
}
