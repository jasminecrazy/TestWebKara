package demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import demo.dao.UserDAO;
import demo.entity.Employee;
import demo.entity.User;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDao;

	@Override
	public List<Employee> findAllUser() {

		return userDao.findAllUser();
	}

	@Override
	public Employee getUser(int id) {
		
		return userDao.getUser(id);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);

	}

	@Override
	public void addUser(Employee user) {
	
	userDao.addUser(user);

	}

	@Override
	public void updateUser(Employee user) {
		userDao.updateUser(user);

	}

	
}
