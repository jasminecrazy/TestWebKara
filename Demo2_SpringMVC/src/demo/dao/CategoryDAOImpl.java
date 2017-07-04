package demo.dao;

import java.util.ArrayList;
import java.util.List;

import demo.entities.Account;
import demo.entities.Category;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> findAll() {
		List<Category> categories = new ArrayList<Category>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			categories = session.createQuery("from Category")
					.list();
			transaction.commit();
		} catch (Exception e) {
			categories = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return categories;
	}

	@Override
	public Category find(int id) {
		Category category = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			category = (Category) session
						.createQuery("select c "
							+ "from Category c "
							+ "where c.id = :id")
						.setInteger("id", id)
					.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			category = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return category;
	}

	
	
}
