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

import demo.entity.Employee;
import demo.entity.User;
import demo.service.UserService;

@RestController

public class UserRestController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllUser() {

		return new ResponseEntity<List<Employee>>(userService.findAllUser(), HttpStatus.OK);
	}

	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getUser(@PathVariable int id) {
		Employee user;
		try {
			user = userService.getUser(id);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "user", method = RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody Employee user) {
		try {
			userService.addUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "user", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@RequestBody Employee user) {
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			System.out.print(e);
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		try {
			userService.deleteUser(id);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
