package dao;

import model.Category;
import java.util.List;

public interface CategoryDAO {
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int categoryId);
    List<Category> getAllCategories();
    Category getCategoryById(int categoryId);
}

