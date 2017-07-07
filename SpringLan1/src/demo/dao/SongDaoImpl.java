package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entity.User;
import demo.entity.Vn;

@Repository("songDao")
public class SongDaoImpl implements SongDao{
	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Vn> findAll() {
		
		List<Vn> song =new ArrayList<Vn>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("from Vn")
					.list();
			transaction.commit();
		} catch (Exception e) {
			song = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return song;
	}

	@Override
	public Vn find(String songname) {
	Vn song = null;
	Session session  =sessionFactory.openSession();
	Transaction transaction =null;
	try {
		transaction = session.beginTransaction();
		song = (Vn) session
				.createQuery("select a "
						+ "from Vn a "
						+ "where a.ten = :ten")
				.setString("ten", songname)
				.uniqueResult();
		transaction.commit();
	} catch (Exception e) {
		song = null;
		if(transaction != null) {
			transaction.rollback();
		}
	} finally {
		session.close();
	}		
	return song;
	}

	@Override
	public void create(Vn song) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(song);
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
	public void delete(Vn song) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(song);
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
	public void update(Vn song) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(song);
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
	public List<Vn> search(String keyword) {
		List<Vn> song= new ArrayList<Vn>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select a "
					+ "from Vn a "
					+ "where a.ten like :keyword")
					.setString("keyword", "%" + keyword + "%")
					.list();
			transaction.commit();
		} catch (Exception e) {
			song = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return song;
	}

}
