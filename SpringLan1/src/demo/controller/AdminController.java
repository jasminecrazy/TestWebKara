package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.service.SongService;

@Controller
@RequestMapping("/admin**")
public class AdminController {
	@Autowired
	private SongService songService;
	@RequestMapping(method=RequestMethod.GET)
public String index(ModelMap modelMap)
{
		modelMap.put("song",songService.findAll());
	return "admin/index";
}
}
