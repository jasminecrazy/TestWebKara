package demo.service;

import java.util.List;

import demo.entity.Employee;
import demo.entity.User;

public interface UserService {
	public List<User> findAllUser();

	public User getUser(int id);

	public void deleteUser(int id);

	public void addUser(User user);

	public void updateUser(User user);

	public void resetPass(User user);


}
