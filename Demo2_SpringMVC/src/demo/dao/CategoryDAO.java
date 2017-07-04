package demo.dao;

import java.util.List;
import demo.entities.Category;

public interface CategoryDAO {

	public List<Category> findAll();
	
	public Category find(int id);
	
}
