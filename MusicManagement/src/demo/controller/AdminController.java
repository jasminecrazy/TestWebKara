package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.org.apache.xpath.internal.operations.Mod;

import demo.entity.Album;
import demo.entity.User;
import demo.service.AlbumService;
import demo.service.AuthorService;
import demo.service.GenreService;
import demo.service.SingerService;
import demo.service.SongService;
import demo.service.UserService;

@Controller
@RequestMapping("/admin**")
public class AdminController {
	@Autowired
	private UserService userService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private SingerService singerService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private SongService songService;
	@Autowired
	private GenreService genreService;

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
	public String add(@ModelAttribute("account") User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.addUser(user);
		return "redirect:../admin.html";
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
	public String edit(@ModelAttribute("account") User account) {
		User currentAccount = userService.getUser(account.getId());
		if (!account.getPassword().isEmpty()) {

			currentAccount.setPassword(passwordEncoder.encode(account.getPassword()));
		}
		currentAccount.setFullname(account.getFullname());
		currentAccount.setEmail(account.getEmail());
		currentAccount.setEnabled(account.isEnabled());
		currentAccount.setPhone(account.getPhone());
		currentAccount.setRole(account.getRole());
		userService.updateUser(currentAccount);
		return "redirect:../admin.html";
	}

	@RequestMapping(value = "author", method = RequestMethod.GET)
	public String author(ModelMap modelMap) {
		modelMap.put("author", authorService.findAllAuthor());

		return "admin/author";
	}

	@RequestMapping(value = "album", method = RequestMethod.GET)
	public String album(ModelMap mm) {
		mm.put("album", albumService.findAllAlbum());

		return "admin/album";
	}
	//Add new Album
	@RequestMapping(value = "add_album", method = RequestMethod.GET)
	public String add_album(ModelMap modelMap) {
		modelMap.put("album", new Album());
		return "admin/add_album";
	}

	@RequestMapping(value = "add_album", method = RequestMethod.POST)
	public String add_album(@ModelAttribute("album") Album album) {
		
		albumService.addAlbum(album);
		return "redirect:../admin/album.html";
	}
	//Update album information
	@RequestMapping(value = "edit_album/{id}", method = RequestMethod.GET)
	public String edit_album(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("album",albumService.getAlbum(id));
		return "admin/edit_album";
	}

	@RequestMapping(value = "edit_album", method = RequestMethod.POST)
	public String edit_album(@ModelAttribute("album") Album album) {
		Album currentAlbum = albumService.getAlbum(album.getId());
		currentAlbum.setAlbumId(album.getAlbumId());
		currentAlbum.setAlbumName(album.getAlbumName());
		albumService.updateAlbum(currentAlbum);
		return "redirect:../admin/album.html";
	}

	@RequestMapping(value = "singer", method = RequestMethod.GET)
	public String singer(ModelMap mm) {
		mm.put("singer", singerService.findAllSinger());
		return "admin/singer";
	}

	@RequestMapping(value = "song", method = RequestMethod.GET)
	public String song(ModelMap modelMap) {

		modelMap.put("song", songService.findAllSongs());
		return "admin/song";
	}

	@RequestMapping(value = "genre", method = RequestMethod.GET)
	public String genre(ModelMap modelMap) {
		modelMap.put("genre", genreService.findAllGenre());
		return "admin/genre";
	}

}
