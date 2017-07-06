package demo.entities;

import org.hibernate.validator.constraints.*;

public class Student {

	@NotEmpty(groups = { Group1.class, Group2.class })
	private String username;

	@NotEmpty(groups = { Group1.class })
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Student() {
		super();
	}

}
