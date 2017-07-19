package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.service.BorrowService;

@Controller
@RequestMapping("/user**")
public class UserController {
	@Autowired
	private BorrowService borrowService;
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "user/index";
	}

	@RequestMapping(value = "detail/{username}", method = RequestMethod.GET)
	public String detail(@PathVariable("username") String username, ModelMap mm ) {
		/*
		 *  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      String name = auth.getName(); //get logged in username

      model.addAttribute("username", name);
		 * */
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 username = auth.getName();
		mm.addAttribute("detail",borrowService.getUserBorow(username));
				//mm.put("detail",borrowService.getUserBorow("user"));
		return "user/detail";
	}
}
