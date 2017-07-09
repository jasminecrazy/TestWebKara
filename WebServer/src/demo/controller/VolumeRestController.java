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

import demo.entity.Volume;
import demo.service.VolumeService;

@RestController
public class VolumeRestController {
	@Autowired
	private VolumeService volumeService;

	@RequestMapping(value = "volume", method = RequestMethod.GET)
	public ResponseEntity<List<Volume>> getAllVolume() {

		return new ResponseEntity<List<Volume>>(volumeService.findAllVol(), HttpStatus.OK);

	}

	@RequestMapping(value = "volume/{id}", method = RequestMethod.GET)
	public ResponseEntity<Volume> getVolume(@PathVariable int id) {
		Volume volume;
		try {
			volume = volumeService.getVol(id);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(volume, HttpStatus.OK);
	}

	@RequestMapping(value = "volume", method = RequestMethod.POST)
	public ResponseEntity<Void> addVolume(@RequestBody Volume volume) {
		try {
			volumeService.addVol(volume);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "volume", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@RequestBody Volume volume) {
		try {
			volumeService.updateVol(volume);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "volume/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVolume(@PathVariable int id) {
		try {
			volumeService.deleteVol(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
