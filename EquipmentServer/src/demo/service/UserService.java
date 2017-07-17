package demo.service;

import java.util.List;

import demo.entity.Employee;
import demo.entity.User;

public interface UserService {
	public List<Employee> findAllUser();

	public Employee getUser(int id);

	public void deleteUser(int id);

	public void addUser(Employee user);

	public void updateUser(Employee user);


}
