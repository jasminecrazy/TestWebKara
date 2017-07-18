package demo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin**")
public class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {

		return "admin/index";
	}

	@RequestMapping(value = "equipment", method = RequestMethod.GET)
	public String equipment() {
		return "admin/equipment";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		return "admin/list";
	}

	@RequestMapping(value = "user", method = RequestMethod.GET)
	public String user() {
		return "admin/user";
	}

}
