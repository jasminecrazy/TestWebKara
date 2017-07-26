package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entity.Songs;

@Repository("SongDAO")
public class SongDAOImpl implements SongDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> findAllSongs() {
		
		List<Songs> songs = new ArrayList<Songs>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			songs = session.createQuery("from Songs").list();
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			songs = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return songs;
	}

	@Override
	public Songs getSongs(int id) {
		Songs song = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = (Songs) session.createQuery("select c from Songs c where c.id =:id").setInteger("id", id).uniqueResult();
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
	public void deleteSongs(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(getSongs(id));
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
	public void addSongs(Songs song) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(song);
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
	public void updateSongs(Songs song) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> getAlbumSong(int id) {
		List<Songs> song = new ArrayList<Songs>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select c from Songs c where c.album.id =:id").setInteger("id", id).list();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> getSingerSong(int id) {
		List<Songs> song = new ArrayList<Songs>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select c from Songs c where c.singer.id =:id").setInteger("id", id).list();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> getGenreSong(int id) {
		List<Songs> song = new ArrayList<Songs>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select c from Songs c where c.genre.id =:id").setInteger("id", id).list();
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
