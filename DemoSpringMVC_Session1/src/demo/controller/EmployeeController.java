package demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import demo.entities.*;
import demo.validators.EmployeeValidator;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		Employee employee = new Employee();
		modelMap.put("employee", employee);
		return "employee/index";
	}
	
	@RequestMapping(value = "save", 
			method = RequestMethod.POST)
	public String save(
		@ModelAttribute("employee") @Valid Employee employee,
		BindingResult bindingResult, 
		ModelMap modelMap) {
		EmployeeValidator employeeValidator = 
				new EmployeeValidator();
		employeeValidator.validate(employee, bindingResult);
		if(bindingResult.hasErrors()) {
			return "employee/index";
		} else {
			modelMap.put("employee", employee);
			return "employee/result";
		}
	}
	
	
}
