package demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import demo.entities.Student;

@Controller
@RequestMapping("session")
public class SessionController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpSession session) {
		session.setAttribute("a", 123);
		session.setAttribute("username", "abc");
		session.setAttribute("student", 
				new Student("st1", "123"));
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("st1", "123"));
		students.add(new Student("st2", "456"));
		students.add(new Student("st3", "789"));
		session.setAttribute("students", students);
		// Remove Session
		session.removeAttribute("a");
		session.removeAttribute("students");
		
		return "session/index";
	}
	
}
