package demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import demo.entities.*;
import demo.validators.StudentValidator;

@Controller
@RequestMapping("student")
public class StudentController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		Student student = new Student();
		modelMap.put("student", student);
		return "student/index";
	}
	
	@RequestMapping(value = "save", 
			method = RequestMethod.POST)
	public String save(
		@Validated({ Group1.class }) 
		@ModelAttribute("student") Student student,
		BindingResult bindingResult, 
		ModelMap modelMap) {
		StudentValidator studentValidator = new StudentValidator();
		studentValidator.validate(student, bindingResult);
		if(bindingResult.hasErrors()) {
			return "student/index";
		} else {
			modelMap.put("student", student);
			return "student/result";
		}
	}
	
	@RequestMapping(value = "edit", 
			method = RequestMethod.GET)
	public String edit(ModelMap modelMap) {
		Student student = new Student();
		modelMap.put("student", student);
		return "student/edit";
	}
	
	@RequestMapping(value = "edit", 
			method = RequestMethod.POST)
	public String edit(
		@Validated({ Group2.class }) 
		@ModelAttribute("student") Student student,
		BindingResult bindingResult, 
		ModelMap modelMap) {
		StudentValidator studentValidator = new StudentValidator();
		studentValidator.validate(student, bindingResult);
		if(bindingResult.hasErrors()) {
			return "student/index";
		} else {
			modelMap.put("student", student);
			return "student/result";
		}
	}
	
	@RequestMapping(value = "search", 
			method = RequestMethod.POST)
	public String search(HttpServletRequest request,
			ModelMap modelMap) {
		String keyword = request.getParameter("keyword");
		modelMap.put("keyword", keyword);
		return "student/search";
	}
	
	
	
	
	
	
	
	
}
