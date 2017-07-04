package demo.dao;

import java.util.List;
import demo.entities.Account;

public interface AccountDAO {

	public List<Account>findAll();
	public Account find(String username);
	public void create(Account account);
	public void delete(Account account);
	public void update(Account account);
	
}
