package demo.services;

import java.util.List;
import demo.entities.Product;

public interface ProductService {

	public List<Product> findAll();
	
	public Product find(int id);
	
}
