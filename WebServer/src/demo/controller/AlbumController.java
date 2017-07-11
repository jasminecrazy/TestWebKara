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

import demo.entity.Album;
import demo.entity.Vn;
import demo.service.AlbumService;

@RestController
public class AlbumController {
	@Autowired
	private AlbumService albumService;

	@RequestMapping(value = "album", method = RequestMethod.GET)
	public ResponseEntity<List<Album>> getAllAlbum() {

		return new ResponseEntity<List<Album>>(albumService.findAllAlbum(), HttpStatus.OK);

	}

	@RequestMapping(value = "album/{id}", method = RequestMethod.GET)
	public ResponseEntity<Album> getAlbum(@PathVariable int id) {
		Album album;
		try {
			album = albumService.getAlbum(id);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(album, HttpStatus.OK);
	}

	@RequestMapping(value = "album", method = RequestMethod.POST)
	public ResponseEntity<Void> addAlbum(@RequestBody Album album) {
		try {
			albumService.addAlbum(album);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "album", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@RequestBody Album album) {
		try {
			albumService.updateAlbum(album);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "album/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAlbum(@PathVariable int id) {
		try {
			albumService.deleteAblum(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "album/getSong/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Vn>> getAlbumSong(@PathVariable int id) {
		return new ResponseEntity<List<Vn>>(albumService.getSongAlbum(id), HttpStatus.OK);
	}
}
