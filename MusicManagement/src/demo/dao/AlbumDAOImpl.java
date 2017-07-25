package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entity.Album;

@Repository("AlbumDAO")
public class AlbumDAOImpl implements AlbumDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> findAllAlbum() {
		
		List<Album> Album = new ArrayList<Album>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Album = session.createQuery("from Album").list();
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Album = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return Album;
	}

	@Override
	public Album getAlbum(int id) {
		Album album = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			album = (Album) session.createQuery("select c from Album c where c.id =:id").setInteger("id", id).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			album = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return album;
	}

	@Override
	public void deleteAlbum(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(getAlbum(id));
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
	public void addAlbum(Album album) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(album);
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
	public void updateAlbum(Album album) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(album);
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
