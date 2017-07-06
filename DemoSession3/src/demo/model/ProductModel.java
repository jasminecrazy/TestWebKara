package demo.model;

import demo.entities.*;
import java.util.*;

public class ProductModel {

	public Product find() {
		return new Product("p01", "name 1", 20);
	}
	
	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("p01", "nokia 1", 2));
		products.add(new Product("p02", "nokia 2", 3));
		products.add(new Product("p03", "samsung 1", 4));
		products.add(new Product("p04", "samsung 2", 4));
		products.add(new Product("p05", "apple 1", 4));
		products.add(new Product("p06", "apple 2", 4));
		products.add(new Product("p07", "apple 3", 4));
		return products;
	}
	
	public List<String> search(String keyword) {
		List<String> products = new ArrayList<String>();
		for(Product product : findAll()) {
			if(product.getName().toLowerCase()
					.startsWith(keyword.toLowerCase())) {
				products.add(product.getName());
			}
		}
		return products;
	}
	
}
