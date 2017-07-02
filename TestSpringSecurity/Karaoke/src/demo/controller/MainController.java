package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("main")
public class MainController {
 @RequestMapping(method=RequestMethod.GET)
	public String index()
 {
	 return "redirect:/main/login.html";
 }
 @RequestMapping(value="login",method=RequestMethod.GET)
 public String login()
 {
	 return "main/login";
 }
 @RequestMapping(value="welcome",method=RequestMethod.GET)
 public String welcome()
 {
	 return "main/welcome";
 }
}
