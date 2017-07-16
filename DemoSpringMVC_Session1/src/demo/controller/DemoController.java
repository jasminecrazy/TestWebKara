package demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("demo")
public class DemoController {
	
	@RequestMapping(value = "demo1", method = RequestMethod.GET)
	public String demo1() {
		return "demo/index";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String demo2(ModelMap modelMap) {
		modelMap.put("a", 123);
		modelMap.put("username", "abc");
		return "demo/demo2";
	}
	
	// localhost:8080/DemoSpringMVC_Session1/demo/hi/kevin.html
	@RequestMapping(value = "hi/{fullName}", method = RequestMethod.GET)
	public String hi(
			@PathVariable("fullName") String fullName, 
			ModelMap modelMap) {
		modelMap.put("result", "Hi " + fullName);
		return "demo/hi";
	}
	
	
	
}
