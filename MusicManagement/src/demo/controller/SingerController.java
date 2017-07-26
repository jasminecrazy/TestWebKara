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

import demo.entity.Album;
import demo.entity.Singer;
import demo.service.SingerService;
import demo.validator.AuthorValidator;
import demo.validator.SingerValidator;

@Controller
@RequestMapping("/admin**")
public class SingerController {
	@Autowired
	private SingerService singerService;

	@RequestMapping(value = "singer", method = RequestMethod.GET)
	public String singer(ModelMap mm) {
		mm.put("singer", singerService.findAllSinger());
		return "admin/singer";
	}

	// Add new Singer
	@RequestMapping(value = "add_singer", method = RequestMethod.GET)
	public String add_album(ModelMap modelMap) {
		modelMap.put("singer", new Singer());
		return "admin/add_singer";
	}

	@RequestMapping(value = "add_singer", method = RequestMethod.POST)
	public String add_album(@ModelAttribute("singer") @Valid Singer singer, BindingResult bindingResult) {
		SingerValidator singerValidator = new SingerValidator();
		singerValidator.validate(singer, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin/add_singer";
		} else {
			Random r = new Random();
			int singerId = r.nextInt(500);
			singer.setSingerId("S" + singerId);
			singerService.addSinger(singer);
			return "redirect:../admin/singer.html";
		}
	}

	// Update singer information
	@RequestMapping(value = "edit_singer/{id}", method = RequestMethod.GET)
	public String edit_singer(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.put("singer", singerService.getSinger(id));
		return "admin/edit_singer";
	}

	@RequestMapping(value = "edit_singer", method = RequestMethod.POST)
	public String edit_singer(@ModelAttribute("singer") @Valid Singer singer, BindingResult bindingResult) {
		SingerValidator singerValidator = new SingerValidator();
		singerValidator.validate(singer, bindingResult);
		if (bindingResult.hasErrors()) {
			return "admin/edit_singer";
		} else {
			Singer currentSinger = singerService.getSinger(singer.getId());
			currentSinger.setSingerId(singer.getSingerId());
			currentSinger.setSingerName(singer.getSingerName());
			singerService.updateSinger(currentSinger);
			return "redirect:../admin/singer.html";
		}
	}

	@RequestMapping(value = "delete_singer/{id}", method = RequestMethod.GET)
	public String delete_singer(@PathVariable("id") Integer id) {
		singerService.deleteSinger(id);
		return "redirect:../../admin/singer.html";
	}
}
