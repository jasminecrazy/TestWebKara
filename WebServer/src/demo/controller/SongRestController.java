package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Vn;
import demo.service.SongService;

@RestController
public class SongRestController {
	@Autowired
	private SongService songService;

	@RequestMapping(value = "song", method = RequestMethod.GET)
	public ResponseEntity<List<Vn>> getAllSong() {
		return new ResponseEntity<List<Vn>>(songService.findAllSong(), HttpStatus.OK);
	}

	@RequestMapping(value = "song/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vn> getSong(@PathVariable int id) {
		Vn song;
		try {
			song = songService.getSong(id);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(song, HttpStatus.OK);
	}
	@RequestMapping(value = "song",method=RequestMethod.POST)
	public ResponseEntity<Void>addSong(@RequestBody Vn song)
	{
		try {
			songService.addSong(song);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping(value = "song",method=RequestMethod.PUT)
	public ResponseEntity<Void>updateSong(@RequestBody Vn song)
	{
		try {
			songService.updateSong(song);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "song/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSong(@PathVariable int id) {
		try {
			songService.deleteSong(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
