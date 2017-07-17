package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.CategoryDAO;
import demo.entity.Category;

@Service("CategoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO categoryDao;

	@Override
	public List<Category> getAllCategory() {

		return categoryDao.getAllCategory();
	}

	@Override
	public Category getCategory(int id) {

		return categoryDao.getCategory(id);
	}

	@Override
	public void deleteCategory(int id) {
		categoryDao.deleteCategory(id);

	}

	@Override
	public void addCategory(Category category) {
		categoryDao.addCategory(category);

	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);

	}

}
