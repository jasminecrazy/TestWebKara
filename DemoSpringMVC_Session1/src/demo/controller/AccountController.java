package demo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import demo.entities.*;
import demo.model.AccountModel;
import demo.model.LanguageModel;
import demo.model.RoleModel;
import org.apache.commons.io.FileUtils;

@Controller
@RequestMapping("account")
public class AccountController 
	implements ServletContextAware {
	
	private ServletContext servletContext;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		LanguageModel languageModel = new LanguageModel();
		RoleModel roleModel = new RoleModel();
		Account account = new Account();
		account.setId(123);
		account.setStatus(true);
		account.setGender("male");
		account.setLanguages(new String[]{ "l1", "l3" });
		modelMap.put("account", account);
		modelMap.put("languages", languageModel.findAll());
		modelMap.put("roles", roleModel.findAll());
		return "account/index";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(
			@ModelAttribute("account") Account account,
			ModelMap modelMap,
			@RequestParam(value = "image", required = false) 
			MultipartFile image) {
		// Upload file
		File file = new File(
				servletContext.getRealPath("/") 
				+ "/assets/images/" + image.getOriginalFilename());
		System.out.println(servletContext.getRealPath("/") 
				+ "/assets/images/" + image.getOriginalFilename());
		try {
			FileUtils.writeByteArrayToFile(file, 
					image.getBytes());
			account.setPhoto(image.getOriginalFilename());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		modelMap.put("account", account);
		return "account/result";
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	private boolean validatePhoto(MultipartFile photo) {
		double size = (photo.getSize()/1024)/1024; 
		if(photo.getContentType().equals("image/gif") 
			|| photo.getContentType().equals("image/png") 
			|| photo.getContentType().equals("image/jpg")
			|| photo.getContentType().equals("image/jpeg")
		) {
			if(size <= 1) {
				return true;
			}
		}
		return false;
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
		AccountModel accountModel = new AccountModel();
		if(accountModel.login(account.getUsername(), 
				account.getPassword())) {
			session.setAttribute("username", 
					account.getUsername());
			return "account/welcome";
		} else {
			modelMap.put("error", "Invalid");
			return "account/login";
		}		
	}
	
	@RequestMapping(value = "logout", 
			method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:login.html";
	}
	
	
	
	
	
	
}
