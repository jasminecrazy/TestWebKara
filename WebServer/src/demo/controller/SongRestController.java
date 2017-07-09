package demo.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import demo.entity.Album;
import demo.entity.Vn;
import demo.entity.Volume;
import demo.service.SongService;

@WebServlet("/uploadFile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
@RestController
public class SongRestController {
	@Autowired
	private SongService songService;
	Vn songObj;

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

	// upload image
	@RequestMapping(value = "song/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {

		try {
			Date todayDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("MMddyyyy_HHmmss");
			String today = dateFormat.format(todayDate);
			// Get the filename
			String filename = today + "_" + uploadfile.getOriginalFilename();
			songObj.setPicture(filename);
			// Build the local file path
			String directory = "assets\\images";
			String filepath = Paths.get(directory, filename).toString();

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(uploadfile.getBytes());
			stream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "song/getVol", method = RequestMethod.GET)
	public ResponseEntity<List<Volume>> getListVol() {
		return new ResponseEntity<List<Volume>>(songService.getListVol(), HttpStatus.OK);
	}

	@RequestMapping(value = "song/getAlbum", method = RequestMethod.GET)
	public ResponseEntity<List<Album>> getListAlbum() {
		return new ResponseEntity<List<Album>>(songService.getListAlbum(), HttpStatus.OK);
	}
}
