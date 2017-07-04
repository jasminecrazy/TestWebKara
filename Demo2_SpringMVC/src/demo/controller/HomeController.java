package demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("home")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "flowershop.home.index";
	}
	
}
