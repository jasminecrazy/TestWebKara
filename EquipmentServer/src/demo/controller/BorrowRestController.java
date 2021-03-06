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

import demo.dto.BorrowDTO;
import demo.entity.Borrow;
import demo.entity.Category;
import demo.entity.Equipment;
import demo.service.BorrowService;

@RestController
public class BorrowRestController {
	@Autowired
	private BorrowService borrowService;

	@RequestMapping(value = "borrowEquipment/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Borrow>> getEquipment(@PathVariable int id) {
		try {
			borrowService.getEquipment(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Borrow>>(borrowService.getEquipment(id), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "borrow", method = RequestMethod.GET)
	public ResponseEntity<List<Borrow>> getAllCategory() {

		return new ResponseEntity<List<Borrow>>(borrowService.getAll(), HttpStatus.OK);
	}
	@RequestMapping(value = "borrow", method = RequestMethod.POST)
	public ResponseEntity<Void> addEquipment(@RequestBody BorrowDTO borrow) {
		try {
			borrowService.addListBorrow(borrow);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "borrow", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEquipment(@RequestBody Borrow borrow) {
		try {
			borrowService.updateListBorrow(borrow);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "borrowlist/{id}", method = RequestMethod.GET)
	public ResponseEntity<Borrow> getBorrowList(@PathVariable int id) {
		Borrow borrow;
		try {
			borrow = borrowService.getListBorrow(id);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(borrow, HttpStatus.OK);
	}

	@RequestMapping(value = "borrow/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBorrowList(@PathVariable int id) {
		try {
			borrowService.deleteBorow(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	@RequestMapping(value = "borrowUser/{username}", method = RequestMethod.GET)
	public ResponseEntity<List<Borrow>> getUserBorrow(@PathVariable String username) {
		try {
			borrowService.getUserBorrow(username);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Borrow>>(borrowService.getUserBorrow(username), HttpStatus.ACCEPTED);
	}
}
