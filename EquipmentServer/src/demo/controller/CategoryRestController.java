package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import demo.entity.Category;
import demo.service.CategoryService;


@RestController
public class CategoryRestController {
	@Autowired
	private CategoryService categoryService;
	@RequestMapping(value = "category", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getAllCategory() {

		return new ResponseEntity<List<Category>>(categoryService.getAllCategory(), HttpStatus.OK);
	}

	@RequestMapping(value = "category/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> getCategory(@PathVariable int id) {
		Category category;
		try {
			category = categoryService.getCategory(id);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@RequestMapping(value = "category", method = RequestMethod.POST)
	public ResponseEntity<Void> addCategory(@RequestBody Category category) {
		try {
			categoryService.addCategory(category);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "category", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateCategory(@RequestBody Category category) {
		try {
			categoryService.updateCategory(category);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "category/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
		try {
			categoryService.deleteCategory(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
