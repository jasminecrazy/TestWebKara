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

	@RequestMapping(value = "vol", method = RequestMethod.GET)
	public String vol() {
		return "admin/vol";
	}

	@RequestMapping(value = "album", method = RequestMethod.GET)
	public String album() {
		return "admin/album";
	}
	
	
	
	
}
