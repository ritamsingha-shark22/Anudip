package menu;

public class Menu {

    public static void showMainMenu() {
        System.out.println("======================================");
        System.out.println("       Personal Finance Tracker       ");
        System.out.println("======================================");
        System.out.println("1. Manage Categories");
        System.out.println("2. Manage Income");
        System.out.println("3. Manage Expenses");
        System.out.println("4. Generate Monthly Report");
        System.out.println("5. View Savings Trend");
        System.out.println("6. Exit");
        System.out.println("======================================");
        System.out.print("Enter your choice: ");
    }

    public static void showCategoryMenu() {
        System.out.println("======================================");
        System.out.println("       Manage Categories       ");
        System.out.println("======================================");
        System.out.println("1. Add Category");
        System.out.println("2. Update Category");
        System.out.println("3. Delete Category");
        System.out.println("4. View All Categories");
        System.out.println("5. Back to Main Menu");
        System.out.println("======================================");
        System.out.print("Enter your choice: ");
    }

    public static void showIncomeMenu() {
        System.out.println("======================================");
        System.out.println("          Manage Income          ");
        System.out.println("======================================");
        System.out.println("1. Add Income");
        System.out.println("2. Update Income");
        System.out.println("3. Delete Income");
        System.out.println("4. View All Income");
        System.out.println("5. Back to Main Menu");
        System.out.println("======================================");
        System.out.print("Enter your choice: ");
    }

    public static void showExpenseMenu() {
        System.out.println("======================================");
        System.out.println("          Manage Expenses          ");
        System.out.println("======================================");
        System.out.println("1. Add Expense");
        System.out.println("2. Update Expense");
        System.out.println("3. Delete Expense");
        System.out.println("4. View All Expenses");
        System.out.println("5. Back to Main Menu");
        System.out.println("======================================");
        System.out.print("Enter your choice: ");
    }
}

