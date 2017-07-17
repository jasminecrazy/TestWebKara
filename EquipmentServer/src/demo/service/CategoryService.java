package demo.service;

import java.util.List;

import demo.entity.Category;

public interface CategoryService {
	public List<Category> getAllCategory();

	public Category getCategory(int id);

	public void deleteCategory(int id);

	public void addCategory(Category category);

	public void updateCategory(Category category);
}
