package demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.entity.User;

@Controller
@RequestMapping("demo")
public class DemoController {
	@RequestMapping(method=RequestMethod.GET)
public String index()
{
	return "demo/index";
}
	
}
