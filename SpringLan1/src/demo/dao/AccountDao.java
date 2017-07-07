package demo.dao;

import java.util.List;

import demo.entity.*;

public interface AccountDao {
	public List<User> findAll();

	public User getUser(int id);

	public User find(String username);

	public void create(User account);

	public void delete(int id);

	public void update(int id);

	public List<User> search(String keyword);

}
