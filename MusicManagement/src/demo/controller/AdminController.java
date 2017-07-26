package demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.entity.User;
import demo.service.UserService;
import demo.validator.UserValidator;

@Controller
@RequestMapping("/admin**")
public class AdminController {
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("accounts", userService.findAllUser());
		return "admin/index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.put("account", new User());
		return "admin/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("account") @Valid User user, BindingResult bindingResult) {
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin/add";
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRole(user.getRole());
			userService.addUser(user);
			return "redirect:../admin.html";
		}
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		return "redirect:../../admin.html";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("account", userService.getUser(id));
		return "admin/edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("account") @Valid User account, BindingResult bindingResult) {
		UserValidator userValidator = new UserValidator();
		userValidator.validate(account, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin/edit";

		} 
		
			User currentAccount = userService.getUser(account.getId());
			if (!account.getPassword().isEmpty()) {

				currentAccount.setPassword(passwordEncoder.encode(account.getPassword()));
			}
			currentAccount.setUsername(account.getUsername());
			currentAccount.setFullname(account.getFullname());
			currentAccount.setEmail(account.getEmail());
			currentAccount.setEnabled(account.isEnabled());
			currentAccount.setPhone(account.getPhone());
			currentAccount.setRole(account.getRole());
			userService.updateUser(currentAccount);
			return "redirect:../admin.html";
		
	}

}
