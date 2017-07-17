package demo.model;

import java.util.*;
import demo.entities.Product;

public class ProductModel {

	public Product find() {
		return new Product("p01", "name 1", 20, 2, "thumb1.gif");
	}
	
	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("p01", "name 1", 
				20, 2, "thumb1.gif"));
		products.add(new Product("p02", "name 2", 
				21, 3, "thumb2.gif"));
		products.add(new Product("p03", "name 3", 
				22, 4, "thumb3.gif"));
		return products;
	}
	
}
