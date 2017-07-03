package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main")
public class MainController {
 @RequestMapping(method=RequestMethod.GET)
	public String index()
 {
	 return "redirect:/main/login.html";
 }
 @RequestMapping(value="login",method=RequestMethod.GET)
 public String login(
		@RequestParam(value = "error", 
			required = false) String error,
		@RequestParam(value = "logout", 
			required = false) String logout,
		ModelMap modelMap
	) {
		if(error != null) {
			modelMap.put("msg", "Wrong password or username");
		}
		if(logout != null) {
			modelMap.put("msg", "Logouted");
		}
		return "main/login";
	}
	
 @RequestMapping(value="welcome",method=RequestMethod.GET)
 public String welcome()
 {
	 return "main/welcome";
 }
}
