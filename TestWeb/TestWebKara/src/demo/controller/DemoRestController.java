package demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoRestController {
	@RequestMapping(value="demo1", method = RequestMethod.GET,produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
public ResponseEntity<String> demo1()
{
	try {
		return new ResponseEntity<String>("demo1",HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}
}
