package model;

public class Category {
    private int id; // Primary key
    private String name;
    private String type; // "Income" or "Expense"

    // Constructor for creating a new category (name and type)
    public Category(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Constructor for retrieving from the database (with ID)
    public Category(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", type=" + type + "]";
    }
}
