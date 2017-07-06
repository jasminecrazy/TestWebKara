package demo.validators;

import org.springframework.validation.*;
import demo.model.*;
import demo.entities.Employee;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Employee.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Employee employee = (Employee) object;
		EmployeeModel employeeModel = new EmployeeModel();
		if(employeeModel.checkUsername(
				employee.getUsername())) {
			errors.rejectValue("username", 
					"account.username.exists");
		}
	}

	
	
}
