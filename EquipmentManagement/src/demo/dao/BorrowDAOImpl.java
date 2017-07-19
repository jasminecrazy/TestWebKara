package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import demo.entity.Borrow;

@Repository("BorrowDAO")
public class BorrowDAOImpl implements BorrowDAO {
	@Autowired
private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Borrow> getUserBorow(String username) {
		List<Borrow> borrow = new ArrayList<Borrow>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			
			transaction = session.beginTransaction();
			borrow =  session.createQuery("select c from Borrow c where c.user.username =: 'admin'").setString("username",username).list();
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			borrow = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return borrow;
	}


	

}
