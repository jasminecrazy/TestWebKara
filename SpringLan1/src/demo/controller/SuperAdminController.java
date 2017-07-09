package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.entity.User;
import demo.service.AccountService;
import demo.service.SongService;

@Controller
@RequestMapping("/superadmin**")
public class SuperAdminController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private SongService songService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("accounts", accountService.findAll());
		return "superadmin/index";
	}

	@RequestMapping(value = "song", method = RequestMethod.GET)
	public String song(ModelMap modelMap) {
		modelMap.put("song", songService.findAll());
		return "superadmin/song";
	}

	@RequestMapping(value = "genre", method = RequestMethod.GET)
	public String genre() {
		return "superadmin/genre";
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
