package demo.entities;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

public class Employee {

	@NotEmpty
	@Length(min = 3, max = 10)
	private String username;

	// aA12@#B
	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
	private String password;

	@Min(18)
	@Max(120)
	private int age;

	@NotEmpty
	@Email
	private String email;

	@URL
	private String website;

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
