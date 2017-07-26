package demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import demo.entity.Album;
import demo.entity.Author;
import demo.entity.Genre;
import demo.entity.Singer;

public class SingerValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
	
		return Singer.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
