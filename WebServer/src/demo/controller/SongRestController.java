package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Album;
import demo.entity.Vn;
import demo.entity.Volume;
import demo.service.SongService;

@RestController
public class SongRestController {
	@Autowired
	private SongService songService;
	Vn songObj;

	@RequestMapping(value = "song", method = RequestMethod.GET)
	public ResponseEntity<List<Vn>> getAllSong() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		headers.add("Access-Control-Max-Age", "3600");
		headers.add("Content-Type", "application/json;charset=UTF-8");
		headers.add("Access-Control-Allow-Headers",
				"X-Requested-With, Content-Type, authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
		return new ResponseEntity<List<Vn>>(songService.findAllSong(),headers, HttpStatus.OK);
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

	@RequestMapping(value = "song", method = RequestMethod.POST)
	public ResponseEntity<Void> addSong(@RequestBody Vn song) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		headers.add("Access-Control-Max-Age", "3600");
		headers.add("Content-Type", "application/json;charset=UTF-8");
		headers.add("Access-Control-Allow-Headers",
				"X-Requested-With, Content-Type, authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
		try {

			songService.addSong(song);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "song", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
	public ResponseEntity<Void> updateSong(@RequestBody Vn song) {
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

	@RequestMapping(value = "song/getVol", method = RequestMethod.GET)
	public ResponseEntity<List<Volume>> getListVol() {
		return new ResponseEntity<List<Volume>>(songService.getListVol(), HttpStatus.OK);
	}

	@RequestMapping(value = "song/getAlbum", method = RequestMethod.GET)
	public ResponseEntity<List<Album>> getListAlbum() {
		return new ResponseEntity<List<Album>>(songService.getListAlbum(), HttpStatus.OK);
	}

	@RequestMapping(value = "song/getHightLightSong", method = RequestMethod.GET)
	public ResponseEntity<List<Vn>> getHightLightSong() {
		return new ResponseEntity<List<Vn>>(songService.getHighLightSong(), HttpStatus.OK);
	}

	@RequestMapping(value = "song/getFavoriteSong", method = RequestMethod.GET)
	public ResponseEntity<List<Vn>> getFavoriteSong() {
		return new ResponseEntity<List<Vn>>(songService.getFavoriteSong(), HttpStatus.OK);
	}

	@RequestMapping(value = "song/getNewestSong", method = RequestMethod.GET)
	public ResponseEntity<List<Vn>> getNewestSong() {
		return new ResponseEntity<List<Vn>>(songService.getNewestSong(), HttpStatus.OK);
	}

	@RequestMapping(value = "song/getVol/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Vn>> getVolSong(@PathVariable int id) {
		return new ResponseEntity<List<Vn>>(songService.getVolSong(id), HttpStatus.OK);
	}

	@RequestMapping(value = "song/sixNumber", method = RequestMethod.GET)
	public ResponseEntity<List<Vn>> getAllSongSixNumber() {
		return new ResponseEntity<List<Vn>>(songService.getSongSixNumber(), HttpStatus.OK);
	}
	@RequestMapping(value= "song/search/{keyword}",method = RequestMethod.GET)
	public ResponseEntity<List<Vn>> getVolSong(@PathVariable String keyword) {
		return new ResponseEntity<List<Vn>>(songService.searchSong(keyword), HttpStatus.OK);
	}
	@RequestMapping(value= "song/searchLyric/{lyric}",method = RequestMethod.GET)
	public ResponseEntity<List<Vn>> searchLyric(@PathVariable String lyric) {
		return new ResponseEntity<List<Vn>>(songService.searchLyricSong(lyric), HttpStatus.OK);
	}
	@RequestMapping(value= "song/searchSong/{songName}",method = RequestMethod.GET)
	public ResponseEntity<List<Vn>> searchSongSixNumber(@PathVariable String songName) {
		return new ResponseEntity<List<Vn>>(songService.searchSongSixNumber(songName), HttpStatus.OK);
	}
	
}
