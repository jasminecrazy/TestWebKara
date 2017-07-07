package demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import demo.dao.UserDAO;
import demo.entity.User;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
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
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	userDao.addUser(user);

	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);

	}

	@Override
	public void resetPass(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userDao.resetPass(user);
		
	}

}
