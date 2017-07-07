package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entity.Vn;

@Repository("SongDAO")
public class SongDAOImpl implements SongDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Vn> findAllSong() {
		List<Vn> song = new ArrayList<Vn>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("from Vn").list();
			transaction.commit();
		} catch (Exception e) {
			song = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return song;
	}

	@Override
	public Vn getSong(int id) {
		Vn song = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = (Vn) session.createQuery("select c from Vn c where c.id =:id").setInteger("id", id).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			song = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return song;
	}

	@Override
	public void deleteSong(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(getSong(id));
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

	}

	@Override
	public void addSong(Vn song) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			/*Vn s = new Vn("HOÀI NIỆM DẤU YÊU", 51615, "Tìm lại chốn cũ năm xưa bên nhau…", "Sinh", "");*/
			
			transaction = session.beginTransaction();
			session.save(song);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

	}

	@Override
	public void updateSong(Vn song) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(song);
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
