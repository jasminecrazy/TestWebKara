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

import demo.entity.Genre;
import demo.service.GenreService;
import demo.validator.GenreValidator;

@Controller
@RequestMapping("/admin**")
public class GenreController {
	@Autowired
	private GenreService genreService;
	@RequestMapping(value = "genre", method = RequestMethod.GET)
	public String genre(ModelMap modelMap) {
		modelMap.put("genre", genreService.findAllGenre());
		return "admin/genre";
	}
	@RequestMapping(value="add_genre", method = RequestMethod.GET)
	public String add_genre(ModelMap modelMap) {
		modelMap.put("genre", new Genre());
		return "admin/add_genre";
	}

	@RequestMapping(value = "add_genre", method = RequestMethod.POST)
	public String add_genre(@ModelAttribute("genre")@Valid Genre genre,BindingResult bindingResult) {
		GenreValidator genreValidator = new GenreValidator();
		genreValidator.validate(genre, bindingResult);
		if(bindingResult.hasErrors())
		{
			return "admin/add_genre";
		}
		else
		{
			Random r= new Random();
			int genreId = r.nextInt(500);
			genre.setGenreId("G"+genreId);
		genreService.addGenre(genre);
		return "redirect:../admin/genre.html";
		}
	}

	@RequestMapping(value = "delete_genre/{id}", method = RequestMethod.GET)
	public String delete_author(@PathVariable("id") Integer id) {
		genreService.deleteGenre(id);
		return "redirect:../../admin/genre.html";
	}

	@RequestMapping(value = "edit_genre/{id}", method = RequestMethod.GET)
	public String edit_genre(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("genre", genreService.getGenre(id));
		return "admin/edit_genre";
	}

	@RequestMapping(value = "edit_genre", method = RequestMethod.POST)
	public String edit_genre(@ModelAttribute("genre")@Valid Genre genre,BindingResult bindingResult) {
		GenreValidator genreValidator = new GenreValidator();
		genreValidator.validate(genre, bindingResult);
		if(bindingResult.hasErrors())
		{
			return "admin/edit_genre";
		}
		else
		{
	Genre currentGenre  = genreService.getGenre(genre.getId());
	currentGenre.setGenreId(genre.getGenreId());
	currentGenre.setGenreName(genre.getGenreName());
	genreService.updateGenre(currentGenre);
		
		return "redirect:../admin/genre.html";
	}
		}
}
