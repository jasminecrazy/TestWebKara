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
import demo.entity.Equipment;
import demo.service.EquipmentService;


@RestController
public class EquipmentRestController {
	@Autowired
	private EquipmentService equipmentService;
	@RequestMapping(value = "equipment", method = RequestMethod.GET)
	public ResponseEntity<List<Equipment>> getAllEquipment() {

		return new ResponseEntity<List<Equipment>>(equipmentService.getAllEquipment(), HttpStatus.OK);
	}

	@RequestMapping(value = "equipment/{id}", method = RequestMethod.GET)
	public ResponseEntity<Equipment> getEquipment(@PathVariable int id) {
		Equipment equipment;
		try {
			equipment = equipmentService.getEquipment(id);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(equipment, HttpStatus.OK);
	}

	@RequestMapping(value = "equipment", method = RequestMethod.POST)
	public ResponseEntity<Void> addEquipment(@RequestBody Equipment equipment) {
		try {
			equipmentService.addEquipment(equipment);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "equipment", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEquipment(@RequestBody Equipment equipment) {
		try {
			equipmentService.updateEquipment(equipment);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "equipment/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEquipment(@PathVariable int id) {
		try {
			equipmentService.deleteEquipment(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
