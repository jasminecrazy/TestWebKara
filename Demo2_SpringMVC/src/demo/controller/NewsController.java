package demo.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("news")
public class NewsController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "news.index";
	}
	
}
