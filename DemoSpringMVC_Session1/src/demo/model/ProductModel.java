package demo.model;

import java.util.*;
import demo.entities.Product;

public class ProductModel {

	public Product find() {
		return new Product("p01", "name 1", 20, 2, "thumb1.gif");
	}
	
}
