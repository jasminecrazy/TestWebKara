package demo.controller;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.entity.Author;
import demo.entity.Role;
import demo.entity.Songs;
import demo.entity.User;
import demo.service.AlbumService;
import demo.service.GenreService;
import demo.service.SingerService;
import demo.service.SongService;
import demo.service.UserService;
import demo.validator.SongValidator;
import demo.validator.UserValidator;

@Controller
@RequestMapping("demo")
public class DemoController {
	@Autowired
	private SongService songService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private GenreService genreService;
	@Autowired
	private SingerService singerService;
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping(method = RequestMethod.GET)
	private String index(ModelMap modelMap) {
		modelMap.put("song", songService.findAllSongs());
		return "demo/index";
	}

	@RequestMapping(value = "singer", method = RequestMethod.GET)
	private String singer(ModelMap modelMap) {
		modelMap.put("singer", singerService.findAllSinger());

		return "demo/singer";

	}

	@RequestMapping(value = "album", method = RequestMethod.GET)
	private String album(ModelMap modelMap) {
		modelMap.put("album", albumService.findAllAlbum());

		return "demo/album";

	}

	@RequestMapping(value = "genre", method = RequestMethod.GET)
	private String genre(ModelMap modelMap) {
		modelMap.put("genre", genreService.findAllGenre());

		return "demo/genre";

	}

	@RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
	private String detail(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("detail", songService.getSongs(id));
		return "demo/detail";
	}

	@RequestMapping(value = "detail_album/{id}", method = RequestMethod.GET)
	private String detail_album(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("detail_album", songService.getAlbumSong(id));
		return "demo/detail_album";
	}

	@RequestMapping(value = "detail_singer/{id}", method = RequestMethod.GET)
	private String detail_singer(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("detail_singer", songService.getSingerSong(id));
		return "demo/detail_singer";
	}

	@RequestMapping(value = "detail_genre/{id}", method = RequestMethod.GET)
	private String detail_genre(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("detail_genre", songService.getGenreSong(id));
		return "demo/detail_genre";
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	private String register(ModelMap modelMap) {
		modelMap.put("register", new User());
		return "demo/register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute("register") @Valid User user, BindingResult bindingResult) {
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "demo/register";
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRole(user.getRole());
			user.setEnabled(true);
			userService.addUser(user);
			return "redirect:../user.html";
		}
	}

}
