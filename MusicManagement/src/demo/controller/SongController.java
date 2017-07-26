package demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import demo.entity.Author;
import demo.entity.Singer;
import demo.entity.Songs;
import demo.service.AlbumService;
import demo.service.AuthorService;
import demo.service.GenreService;
import demo.service.SingerService;
import demo.service.SongService;

@Controller
@RequestMapping("/admin**")
public class SongController {
	@Autowired
	private SongService songService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private SingerService singerService;
	@Autowired
	private GenreService genreService;

	@RequestMapping(value = "song", method = RequestMethod.GET)
	public String song(ModelMap modelMap) {
		modelMap.put("song", songService.findAllSongs());
		return "admin/song";
	}

	@RequestMapping(value = "add_song", method = RequestMethod.GET)
	public String add_song(ModelMap modelMap) {

		List<Author> author = authorService.findAllAuthor();
		modelMap.put("author", author);
		modelMap.put("singer", singerService.findAllSinger());
		modelMap.put("album", albumService.findAllAlbum());
		modelMap.put("genre", genreService.findAllGenre());
		
		
		modelMap.put("song", new Songs());

		return "admin/add_song";
	}

	@RequestMapping(value = "add_song", method = RequestMethod.POST)
	public String add_song(@ModelAttribute("song") Songs song) {
		Random r = new Random();
		int songId = r.nextInt(5000);
		song.setSongId("S" + songId);
		song.setStatus(true);
		song.setAlbum(song.getAlbum());
		song.setAuthor(song.getAuthor());
		song.setGenre(song.getGenre());
		song.setLyric(song.getLyric());
		song.setSinger(song.getSinger());
		song.setSongName(song.getSongName());
		
		songService.addSongs(song);
		return "redirect:../admin/song.html";
	}

	@RequestMapping(value = "delete_song/{id}", method = RequestMethod.GET)
	public String delete_song(@PathVariable("id") Integer id) {
		songService.deleteSongs(id);
		return "redirect:../../admin/song.html";
	}

	@RequestMapping(value = "edit_song/{id}", method = RequestMethod.GET)
	public String edit_song(@PathVariable("id") Integer id, ModelMap modelMap) {
		List<Author> author = authorService.findAllAuthor();

		modelMap.put("author", author);
		
		modelMap.put("singer", singerService.findAllSinger());
		modelMap.put("album", albumService.findAllAlbum());
		modelMap.put("genre", genreService.findAllGenre());
		modelMap.put("song", songService.getSongs(id));
		return "admin/edit_song";
	}

	@RequestMapping(value = "edit_song", method = RequestMethod.POST)
	public String edit_song(@ModelAttribute("song") Songs song) {
		Songs currentSong = songService.getSongs(song.getId());
		Random r = new Random();
		int songId = r.nextInt(5000);
		currentSong.setSongId("A" + songId);
		currentSong.setSongName(song.getSongName());
		currentSong.setAlbum(song.getAlbum());
		currentSong.setAuthor(song.getAuthor());
		currentSong.setGenre(song.getGenre());
		currentSong.setLyric(song.getLyric());
		currentSong.setSinger(song.getSinger());
		currentSong.setStatus(song.getStatus());
		return "redirect:../admin/song.html";
	}

}
