package demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import demo.entity.Album;
import demo.entity.Author;
import demo.entity.Genre;

public class AuthorValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
	
		return Author.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
