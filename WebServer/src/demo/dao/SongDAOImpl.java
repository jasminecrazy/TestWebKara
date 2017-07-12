package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entity.Album;
import demo.entity.Vn;
import demo.entity.Volume;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Volume> getListVol() {

		List<Volume> vol = new ArrayList<Volume>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			vol = session.createQuery("from Volume").list();
			transaction.commit();
		} catch (Exception e) {
			vol = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return vol;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Album> getListAlbum() {
		List<Album> album = new ArrayList<Album>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			album = session.createQuery("from Album").list();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Vn> getHighLightSong() {
		List<Vn> song = new ArrayList<Vn>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select c from Vn c where baihatnoibat = true").setMaxResults(4).list();
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
	public List<Vn> getFavoriteSong() {
		List<Vn> song = new ArrayList<Vn>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select c from Vn c where baihatyeuthich = true").setMaxResults(15).list();
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
	public List<Vn> getNewestSong() {
		List<Vn> song = new ArrayList<Vn>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select c from Vn c where c.volume.id >= All(Select v.id from Volume v)").list();
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	public List<Vn> getVolSong(int id) {

		List<Vn> song = new ArrayList<Vn>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select c from Vn c where c.volume.id = :id ").setMaxResults(20).setInteger("id",id).list();
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
	public List<Vn> getSongSixNumber() {
		List<Vn> song = new ArrayList<Vn>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select c from Vn c where c.masauso is not null").list();
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
	public List<Vn> searchSong(String keyword) {
		List<Vn> song = new ArrayList<Vn>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			song = session.createQuery("select c from Vn c where c.ten like :keyword").setString("keyword","%"+keyword+"%").list();
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
}
