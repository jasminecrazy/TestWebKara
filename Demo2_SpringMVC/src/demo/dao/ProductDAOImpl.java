package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entities.Category;
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

	@Override
	public Product find(int id) {
		Product product = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			product = (Product) session
						.createQuery("select p "
							+ "from Product p "
							+ "where p.id = :id")
						.setInteger("id", id)
					.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			product = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return product;
	}
	
}
