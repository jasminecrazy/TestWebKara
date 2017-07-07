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
	@RequestMapping(method=RequestMethod.GET)
public String index(ModelMap modelMap)
{
		modelMap.put("accounts", 
				accountService.findAll());
	return "superadmin/index";
}
	@RequestMapping(value="song",method=RequestMethod.GET)
	public String song(ModelMap modelMap)
	{
		modelMap.put("song",songService.findAll());
		return "superadmin/song";
	}

	//Create/Save
	@RequestMapping(value="add",method= RequestMethod.GET)
	public String save(ModelMap modelMap )
	{
		modelMap.put("user", new User());
		return "superadmin/add";
		
	}
	@RequestMapping(value="add",method= RequestMethod.POST)
	public String save(@ModelAttribute("user") User user,ModelMap modelMap )
	{
		accountService.create(user);
		return "redirect:/superadmin.html";
		
	}
	@RequestMapping(value="delete/{id}",method= RequestMethod.GET)
	public String delete(@PathVariable ("id") Integer id)
	{
		accountService.delete(id);
		return "redirect:/superadmin.html";
		
	}
	@RequestMapping(value="edit/{id}",method= RequestMethod.GET)
	public String edit(@PathVariable ("id") Integer id,ModelMap modalMap)
	{
		modalMap.put("user",accountService.getUser(id));
		return "superadmin/edit";
		
	}
	@RequestMapping(value="edit",method= RequestMethod.POST)
	public String edit(@ModelAttribute("user") User user )
	{
		accountService.create(user);
		return "redirect:/superadmin.html";
		
	}
	
}
