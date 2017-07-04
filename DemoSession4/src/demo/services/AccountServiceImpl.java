package demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.AccountDAO;
import demo.entities.Account;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	public Account find(String username) {
		return accountDAO.find(username);
	}

	public void create(Account account) {
		accountDAO.create(account);
		
	}

	public void delete(Account account) {
	accountDAO.delete(account);
		
	}

	public void update(Account account) {
		accountDAO.update(account);
		
	}

}
