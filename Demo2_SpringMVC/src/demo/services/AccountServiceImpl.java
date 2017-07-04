package demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import demo.entities.Account;
import demo.dao.*;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	@Override
	public Account find(String username) {
		return accountDAO.find(username);
	}

	@Override
	public void create(Account account) {
		accountDAO.create(account);
	}

	@Override
	public void delete(Account account) {
		accountDAO.delete(account);
	}

	@Override
	public void update(Account account) {
		accountDAO.update(account);
	}

	@Override
	public List<Account> search(String keyword) {
		return accountDAO.search(keyword);
	}

	@Override
	public Account login(String username, String password) {
		return accountDAO.login(username, password);
	}

}
