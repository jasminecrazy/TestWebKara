package demo.validators;

import org.springframework.validation.*;
import demo.model.*;
import demo.entities.Employee;
import demo.entities.Student;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Student.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
	}

	
	
}
