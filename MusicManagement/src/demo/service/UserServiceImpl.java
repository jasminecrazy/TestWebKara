package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.UserDAO;
import demo.entity.User;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
private UserDAO userDao;
	@Override
	public List<User> findAllUser() {
		
		return userDao.findAllUser();
	}

	@Override
	public User getUser(int id) {
		
		return userDao.getUser(id);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
		
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
		
	}

}
