package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import demo.services.CategoryService;
import demo.services.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "detail/{id}", 
			method = RequestMethod.GET)
	public String detail(
		@PathVariable("id") int id, 
		ModelMap modelMap) {
		modelMap.put("product", 
				productService.find(id));
		return "product.detail";
	}
	
}
