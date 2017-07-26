package demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import demo.entity.Songs;

public class SongValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Songs.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
