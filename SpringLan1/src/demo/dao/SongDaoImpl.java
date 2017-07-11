package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entity.Album;
import demo.entity.Vn;

@Repository("SongDao")

public class SongDaoImpl implements SongDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<String> search(String songName) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vn> getSongVol(int id) {
		
		List<Vn> song = new ArrayList<Vn>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select c from Vn c where c.volume.id = :id ").setInteger("id",id).list();
			transaction.commit();
		} catch (Exception e) {
			song = null;
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return song;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vn> getAlbumSong(int id) {
		List<Vn> song = new ArrayList<Vn>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select c from Vn c where c.album.id = :id ").setInteger("id",id).list();
			transaction.commit();
		} catch (Exception e) {
			song = null;
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
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

}
