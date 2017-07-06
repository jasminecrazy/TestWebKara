package demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import demo.services.*;
import demo.entities.*;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("accounts", 
				accountService.findAll());
		return "account/index";
	}
	
	@RequestMapping(value = "add", 
			method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.put("account", new Account());
		return "account/add";
	}
	
	@RequestMapping(value = "add", 
			method = RequestMethod.POST)
	public String add(
		@ModelAttribute("account") Account account) {
		account.setPassword(passwordEncoder
				.encode(account.getPassword()));
		accountService.create(account);
		return "redirect:../account.html";
	}
	
	@RequestMapping(value = "delete/{username}", 
			method = RequestMethod.GET)
	public String delete(
		@PathVariable("username") String username) {
		accountService.delete(
				accountService.find(username));
		return "redirect:../../account.html";
	}
	
	@RequestMapping(value = "edit/{username}", 
			method = RequestMethod.GET)
	public String edit(
		@PathVariable("username") String username, 
		ModelMap modelMap) {
		modelMap.put("account", 
				accountService.find(username));		
		return "account/edit";
	}
	
	@RequestMapping(value = "edit", 
			method = RequestMethod.POST)
	public String edit(
		@ModelAttribute("account") Account account) {
		Account currentAccount = accountService
				.find(account.getUsername());
		if(!account.getPassword().isEmpty()) {
			 
			currentAccount.setPassword(
				passwordEncoder.encode(account
						.getPassword()));
		}
		currentAccount.setFullname(account.getFullname());
		currentAccount.setEmail(account.getEmail());
		accountService.update(currentAccount);
		return "redirect:../account.html";
	}
	
	@RequestMapping(value = "search", 
			method = RequestMethod.POST)
	public String search(
		HttpServletRequest request, 
		ModelMap modelMap) {
		String keyword = request.getParameter("keyword");
		modelMap.put("keyword", keyword);
		modelMap.put("accounts", 
				accountService.search(keyword));
		return "account/index";
	}
	
	@RequestMapping(value = "login", 
			method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.put("account", new Account());
		return "account/login";
	}
	
	@RequestMapping(value = "login", 
			method = RequestMethod.POST)
	public String login(
		@ModelAttribute("account") Account account,
		HttpSession session, 
		ModelMap modelMap) {
		Account account2 = accountService.login(
				account.getUsername(), 
				account.getPassword());
		if(account2 == null) {
			modelMap.put("error", "Invalid");
			return "account/login";
		} else {
			session.setAttribute("username", 
					account.getUsername());
			return "account/welcome";
		}
	}
	
	@RequestMapping(value = "logout", 
			method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:../account.html";
	}
	
	@RequestMapping(value = "changeprofile", 
			method = RequestMethod.GET)
	public String changeProfile(
		HttpSession session,
		ModelMap modelMap) {
		String username = session
				.getAttribute("username").toString();
		modelMap.put("account", 
				accountService.find(username));		
		return "account/edit";
	}
	
	@RequestMapping(value = "order/{username}", 
			method = RequestMethod.GET)
	public String order(
			@PathVariable("username") String username,
		ModelMap modelMap) {		
		modelMap.put("orders", 
				accountService.find(username).getOrderses());		
		return "account/orders";
	}
	
	
}
