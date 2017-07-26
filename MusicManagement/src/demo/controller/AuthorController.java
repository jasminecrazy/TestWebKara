package demo.controller;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.entity.Author;
import demo.service.AuthorService;
import demo.validator.AuthorValidator;

@Controller
@RequestMapping("/admin**")
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "author", method = RequestMethod.GET)
	public String author(ModelMap modelMap) {
		modelMap.put("author", authorService.findAllAuthor());

		return "admin/author";
	}

	@RequestMapping(value = "add_author", method = RequestMethod.GET)
	public String add_author(ModelMap modelMap) {
		modelMap.put("author", new Author());
		return "admin/add_author";
	}

	@RequestMapping(value = "add_author", method = RequestMethod.POST)
	public String add_author(@ModelAttribute("author") @Valid Author author, BindingResult bindingResult) {
		AuthorValidator authorValidator = new AuthorValidator();
		authorValidator.validate(author, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin/add_author";
		} else {
			Random r = new Random();
			int authorId = r.nextInt(500);
			author.setAuthorId("A" + authorId);
			authorService.addAuthor(author);
			return "redirect:../admin/author.html";
		}
	}

	@RequestMapping(value = "delete_author/{id}", method = RequestMethod.GET)
	public String delete_author(@PathVariable("id") Integer id) {
		authorService.deleteAuthor(id);
		return "redirect:../../admin/author.html";
	}

	@RequestMapping(value = "edit_author/{id}", method = RequestMethod.GET)
	public String edit_author(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("author", authorService.getAuthor(id));
		return "admin/edit_author";
	}

	@RequestMapping(value = "edit_author", method = RequestMethod.POST)
	public String edit_author(@ModelAttribute("author") @Valid Author author, BindingResult bindingResult) {
		AuthorValidator authorValidator = new AuthorValidator();
		authorValidator.validate(author, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin/edit_author";
		} else {

			Author currenntAuthor = authorService.getAuthor(author.getId());
			currenntAuthor.setAuthorId(author.getAuthorId());
			currenntAuthor.setAuthorname(author.getAuthorname());
			authorService.updateAuthor(currenntAuthor);

			return "redirect:../admin/author.html";
		}
	}
}
