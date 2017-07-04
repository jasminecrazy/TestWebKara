package demo.services;

import java.util.List;
import demo.entities.Account;

public interface AccountService {
	
	public List<Account> findAll();
	public Account find(String username);
	public void create(Account account);
	public void delete(Account account);
	public void update(Account account);
}
