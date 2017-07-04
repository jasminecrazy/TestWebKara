package demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import demo.dao.CategoryDAO;
import demo.entities.Category;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}

	@Override
	public Category find(int id) {
		return categoryDAO.find(id);
	}

	
	
}
