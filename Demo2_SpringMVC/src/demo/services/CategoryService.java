package demo.services;

import java.util.List;
import demo.entities.Category;

public interface CategoryService {

	public List<Category> findAll();
	
	public Category find(int id);
	
}
