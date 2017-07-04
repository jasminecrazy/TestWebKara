package demo.dao;

import java.util.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;
import demo.entities.*;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			accounts = session.createQuery("from Account")
					.list();
			transaction.commit();
		} catch (Exception e) {
			accounts = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return accounts;
	}

	public Account find(String username) {
		Account account = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			account = (Account) session.createQuery("select a "+"from Account a "+"where a.username = :username").setString("username", username)
					.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			account = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return account;
	}

	public void create(Account account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(account);
			transaction.commit();
		} catch (Exception e) {
			
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		
		
	}

	public void delete(Account account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(account);
			transaction.commit();
		} catch (Exception e) {
			
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		
	}

	public void update(Account account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(account);
			transaction.commit();
		} catch (Exception e) {
			
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		
	}
	
}
