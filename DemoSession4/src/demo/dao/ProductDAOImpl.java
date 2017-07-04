package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import demo.entities.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			products = session.createQuery("from Product")
					.list();
			transaction.commit();
		} catch (Exception e) {
			products = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}
	
}
