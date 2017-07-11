package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/superadmin**")
public class SuperAdminController {
	

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		
		return "superadmin/index";
	}

	@RequestMapping(value = "song", method = RequestMethod.GET)
	public String song() {
		
		return "superadmin/song";
	}


	@RequestMapping(value = "vol", method = RequestMethod.GET)
	public String vol() {
		return "superadmin/vol";
	}

	@RequestMapping(value = "album", method = RequestMethod.GET)
	public String album() {
		return "superadmin/album";
	}

}
