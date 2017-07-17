package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import demo.entity.Category;

@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategory() {
		List<Category> category = new ArrayList<Category>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			category = session.createQuery("from Category").list();
			transaction.commit();
		} catch (Exception e) {
			category = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return category;
	}

	@Override
	public Category getCategory(int id) {
		Category category = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			category = (Category) session.createQuery("select c from Category c where c.id =:id").setInteger("id", id).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			category = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return category;
	}

	@Override
	public void deleteCategory(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(getCategory(id));
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public void addCategory(Category category) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(category);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public void updateCategory(Category category) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(category);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

	}

}
