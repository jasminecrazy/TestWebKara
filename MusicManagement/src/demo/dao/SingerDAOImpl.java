package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entity.Singer;

@Repository("SingerDAO")
public class SingerDAOImpl implements SingerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Singer> findAllSinger() {

		List<Singer> Singer = new ArrayList<Singer>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Singer = session.createQuery("from Singer").list();
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Singer = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return Singer;
	}

	@Override
	public Singer getSinger(int id) {
		Singer singer = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			singer = (Singer) session.createQuery("select c from Singer c where c.id =:id").setInteger("id", id)
					.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			singer = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return singer;
	}

	@Override
	public void deleteSinger(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(getSinger(id));
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
	public void addSinger(Singer singer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(singer);
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
	public void updateSinger(Singer singer) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(singer);
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
