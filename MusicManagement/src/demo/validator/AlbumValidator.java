package demo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import demo.entity.Album;

public class AlbumValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
	
		return Album.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
