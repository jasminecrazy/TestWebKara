package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String detail(@PathVariable ("username") String username, ModelMap mm ) {
		
		/*User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      String name = user.getUsername(); //get logged in username
*/		mm.put("detail",borrowService.getUserBorow(username));
		return "user/detail";
	}
}
