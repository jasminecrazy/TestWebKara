package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.AccountDao;
import demo.entity.User;
@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired
private AccountDao accounDao;
	@Override
	public List<User> findAll() {
		
		return accounDao.findAll();
	}

	@Override
	public User find(String username) {
		
		return accounDao.find(username);
	}

	@Override
	public void create(User account) {
		accounDao.create(account);
		
	}

	@Override
	public void delete(int id) {
		accounDao.delete(id);
		
	}

	@Override
	public void update(int id) {
		accounDao.update(id);
		
	}

	@Override
	public List<User> search(String keyword) {
		
		return accounDao.search(keyword);
	}

	@Override
	public User getUser(int id) {
		
		return accounDao.getUser(id);
	}

	

}
