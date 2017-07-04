package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import demo.services.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "find/{id}", 
			method = RequestMethod.GET)
	public String find(
		@PathVariable("id") int id, 
		ModelMap modelMap) {
		modelMap.put("category", 
				categoryService.find(id));
		return "category.find";
	}
	
}
