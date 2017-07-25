package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entity.Author;
import demo.entity.User;

@Repository("AuthorDAO")
public class AuthorDAOImpl implements AuthorDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> findAllAuthor() {
		
		List<Author> author = new ArrayList<Author>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			author = session.createQuery("from Author").list();
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			author = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return author;
	}

	@Override
	public Author getAuthor(int id) {
		Author author = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			author = (Author) session.createQuery("select c from Author c where c.id =:id").setInteger("id", id).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			author = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return author;
	}

	@Override
	public void deleteAuthor(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(getAuthor(id));
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
	public void addAuthor(Author author) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(author);
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
	public void updateAuthor(Author author) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(author);
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
