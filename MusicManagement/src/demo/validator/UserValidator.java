package demo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import demo.entity.User;
import demo.service.UserService;

public class UserValidator implements Validator {
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> arg0) {

		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
String password= user.getPassword();
String retypePass = user.getRetypePassword();
if(!password.equals(retypePass)){
    errors.rejectValue("retypePassword","notmatch.password");
}
//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		
	/*if (userService.findByUsername(user.getUsername()) != null) {
			//errors.rejectValue("username", "account.username.exists");
		}*/

	}
	

}
