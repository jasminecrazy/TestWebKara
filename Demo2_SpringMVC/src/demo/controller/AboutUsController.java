package demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("aboutus")
public class AboutUsController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "aboutus.index";
	}
	
}
