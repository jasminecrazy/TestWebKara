package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import demo.services.*;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("accounts", 
				accountService.findAll());
		return "account/index";
	}
	
	
}
