package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import demo.entity.User;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao{
	@Autowired
	private SessionFactory sessionFactory;
	 
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		List<User> accounts =new ArrayList<User>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			accounts = session.createQuery("from User")
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

	@Override
	public User find(String username) {
			User account =null;
			Session session = sessionFactory.openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				account = (User) session
						.createQuery("select a "
								+ "from User a "
								+ "where a.username = :username")
						.setString("username", username)
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

	@Override
	public void create(User account) {
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

	@Override
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(id);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}	
		
	}

	@Override
	public void update(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(id);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}	
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> search(String keyword) {
		List<User>accounts= new ArrayList<User>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			accounts = session.createQuery("select a "
					+ "from User a "
					+ "where a.fullname like :keyword")
					.setString("keyword", "%" + keyword + "%")
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

	@Override
	public User getUser(int id) {
		User account = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			account = (User) session.createQuery("select c from User c where c.id =:id").setInteger("id", id).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			account = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return account;
	}

	

}
