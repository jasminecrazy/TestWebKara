package demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import demo.entities.Product;
import demo.model.ProductModel;

@Controller
@RequestMapping("demo")
public class DemoController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "demo/index";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search() {
		return "demo/search";
	}
	
	@RequestMapping(value = "process", 
			method = RequestMethod.GET)
	@ResponseBody
	public List<String> process(
			HttpServletRequest request) {
		String keyword = request.getParameter("term");
		ProductModel productModel = new ProductModel();
		return productModel.search(keyword);
	}
	
	@RequestMapping(value = "work1", 
			method = RequestMethod.GET)
	@ResponseBody
	public String work1() {
		return "Hello Ajax";
	}
	
	@RequestMapping(value = "work2/{fullName}", 
			method = RequestMethod.GET)
	@ResponseBody
	public String work2(
		@PathVariable("fullName") String fullName) {
		return "Hi " + fullName;
	}
	
	@RequestMapping(value = "work3", 
			method = RequestMethod.GET)
	@ResponseBody
	public Product work3() {
		ProductModel productModel = new ProductModel();
		return productModel.find();
	}
	
	@RequestMapping(value = "work4", 
			method = RequestMethod.GET)
	@ResponseBody
	public List<Product> work4() {
		ProductModel productModel = new ProductModel();
		return productModel.findAll();
	}
	
	
	
}
