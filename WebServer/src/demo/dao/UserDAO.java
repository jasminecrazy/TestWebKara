package demo.dao;

import java.util.List;

import demo.entity.User;
import demo.entity.Vn;

public interface UserDAO {
	public List<User> findAllUser();

	public User getUser(int id);

	public void deleteUser(int id);

	public void addUser(User user);

	public void updateUser(User user);
	public void resetPass(User user);
}
