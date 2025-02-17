package ui;



import menu.Menu;
import daoimpl.CategoryDAOImpl;
import daoimpl.IncomeDAOImpl;
import daoimpl.ExpenseDAOImpl;
import model.Category;
import model.Income;
import model.Expense;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        IncomeDAOImpl incomeDAO = new IncomeDAOImpl();
        ExpenseDAOImpl expenseDAO = new ExpenseDAOImpl();

        while (true) {
            Menu.showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageCategories(categoryDAO);
                    break;
                case 2:
                    manageIncome(incomeDAO);
                    break;
                case 3:
                    manageExpenses(expenseDAO);
                    break;
                case 4:
                    generateMonthlyReport();
                    break;
                case 5:
                    viewSavingsTrend();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageCategories(CategoryDAOImpl categoryDAO) {
        while (true) {
            Menu.showCategoryMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Category
                    System.out.print("Enter category name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter category type (Income/Expense): ");
                    String type = scanner.nextLine();
                    categoryDAO.addCategory(new Category(name, type));
                    System.out.println("Category added successfully!");
                    break;
                case 2: // Update Category
                    System.out.print("Enter category ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new category name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new category type (Income/Expense): ");
                    type = scanner.nextLine();
                    categoryDAO.updateCategory(new Category(id, name, type));
                    System.out.println("Category updated successfully!");
                    break;
                case 3: // Delete Category
                    System.out.print("Enter category ID to delete: ");
                    id = scanner.nextInt();
                    categoryDAO.deleteCategory(id);
                    System.out.println("Category deleted successfully!");
                    break;
                case 4: // View All Categories
                    List<Category> categories = categoryDAO.getAllCategories();
                    System.out.println("Categories:");
                    for (Category category : categories) {
                        System.out.println(category);
                    }
                    break;
                case 5: // Back to Main Menu
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageIncome(IncomeDAOImpl incomeDAO) {
        while (true) {
            Menu.showIncomeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Income
                    System.out.print("Enter income amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter income date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter income description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter category ID: ");
                    int categoryId = scanner.nextInt();
                    incomeDAO.addIncome(new Income(amount, date, description, categoryId));
                    System.out.println("Income added successfully!");
                    break;
                case 2: // Update Income
                    System.out.print("Enter income ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new income amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter new income date (yyyy-mm-dd): ");
                    date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter new income description: ");
                    description = scanner.nextLine();
                    System.out.print("Enter new category ID: ");
                    categoryId = scanner.nextInt();
                    incomeDAO.updateIncome(new Income(id, amount, date, description, categoryId));
                    System.out.println("Income updated successfully!");
                    break;
                case 3: // Delete Income
                    System.out.print("Enter income ID to delete: ");
                    id = scanner.nextInt();
                    incomeDAO.deleteIncome(id);
                    System.out.println("Income deleted successfully!");
                    break;
                case 4: // View All Income
                    List<Income> incomes = incomeDAO.getAllIncomes();
                    System.out.println("Income Records:");
                    for (Income income : incomes) {
                        System.out.println(income);
                    }
                    break;
                case 5: // Back to Main Menu
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageExpenses(ExpenseDAOImpl expenseDAO) {
        while (true) {
            Menu.showExpenseMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Expense
                    System.out.print("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter expense date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter expense description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter category ID: ");
                    int categoryId = scanner.nextInt();
                    expenseDAO.addExpense(new Expense(amount, date, description, categoryId));
                    System.out.println("Expense added successfully!");
                    break;
                case 2: // Update Expense
                    System.out.print("Enter expense ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new expense amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter new expense date (yyyy-mm-dd): ");
                    date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter new expense description: ");
                    description = scanner.nextLine();
                    System.out.print("Enter new category ID: ");
                    categoryId = scanner.nextInt();
                    expenseDAO.updateExpense(new Expense(id, amount, date, description, categoryId));
                    System.out.println("Expense updated successfully!");
                    break;
                case 3: // Delete Expense
                    System.out.print("Enter expense ID to delete: ");
                    id = scanner.nextInt();
                    expenseDAO.deleteExpense(id);
                    System.out.println("Expense deleted successfully!");
                    break;
                case 4: // View All Expenses
                    List<Expense> expenses = expenseDAO.getAllExpenses();
                    System.out.println("Expense Records:");
                    for (Expense expense : expenses) {
                        System.out.println(expense);
                    }
                    break;
                case 5: // Back to Main Menu
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void generateMonthlyReport() {
        System.out.println("Feature coming soon...");
    }

    private static void viewSavingsTrend() {
        System.out.println("Feature coming soon...");
    }
}


