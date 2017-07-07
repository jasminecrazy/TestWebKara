package demo.service;

import java.util.List;

import demo.entity.User;

public interface AccountService {
	public List<User> findAll();

	public User find(String username);

	public void create(User account);

	public void delete(int id);

	public void update(int id);

	public List<User> search(String keyword);

	public User getUser(int id);

	
}
