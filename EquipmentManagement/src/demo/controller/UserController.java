package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.service.EquipmentService;

@Controller
@RequestMapping("/user**")
public class UserController {
	@Autowired
	private EquipmentService equipmentService;
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "user/index";
	}

	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") int id,ModelMap modelMap) {
		modelMap.put("detail",equipmentService.getEquipment(id));
		return "user/detail";
	}
}
