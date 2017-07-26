package demo.controller;

import java.util.List;
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

import demo.entity.Album;
import demo.service.AlbumService;
import demo.validator.AlbumValidator;

@Controller
@RequestMapping("/admin**")
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	@RequestMapping(value = "album", method = RequestMethod.GET)
	public String album(ModelMap modelMap) {
		modelMap.put("album", albumService.findAllAlbum());
		return "admin/album";
	}

	@RequestMapping(value = "add_album", method = RequestMethod.GET)
	public String add_album(ModelMap modelMap) {
		modelMap.put("album", new Album());

		return "admin/add_album";
	}

	@RequestMapping(value = "add_album", method = RequestMethod.POST)
	public String add_album(@ModelAttribute("album") @Valid Album album, BindingResult bindingResult) {
		AlbumValidator albumValidator = new AlbumValidator();
		albumValidator.validate(album, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin/add_album";
		} else {
			Random r = new Random();
			int albumId = r.nextInt(5000);
			album.setAlbumId("A" + albumId);
			albumService.addAlbum(album);
			return "redirect:../admin/album.html";
		}
	}

	@RequestMapping(value = "delete_album/{id}", method = RequestMethod.GET)
	public String delete_album(@PathVariable("id") Integer id) {
		albumService.deleteAlbum(id);
		return "redirect:../../admin/album.html";
	}

	@RequestMapping(value = "edit_album/{id}", method = RequestMethod.GET)
	public String edit_album(@PathVariable("id") Integer id, ModelMap modelMap) {

		modelMap.put("album", albumService.getAlbum(id));
		return "admin/edit_album";
	}

	@RequestMapping(value = "edit_album", method = RequestMethod.POST)
	public String edit_album(@ModelAttribute("album") @Valid Album album, BindingResult bindingResult) {
		AlbumValidator validator = new AlbumValidator();
		validator.validate(album, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin/edit_album";
		} else {
			Album currentalbum = albumService.getAlbum(album.getId());

			currentalbum.setAlbumId(album.getAlbumId());
			currentalbum.setAlbumName(album.getAlbumName());
			albumService.updateAlbum(currentalbum);
			return "redirect:../admin/album.html";
		}
	}

}
