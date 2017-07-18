package demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.dto.BorrowDTO;
import demo.entity.Borrow;
import demo.entity.Category;
import demo.entity.Employee;
import demo.entity.Equipment;
import demo.entity.User;

@Repository("BorrowDAO")
public class BorrowDAOImpl implements BorrowDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Borrow> getEquipment(int id) {
		List<Borrow> borrowEquipment = new ArrayList<Borrow>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			borrowEquipment = session.createQuery("select b from Equipment b where b.id=:id")
					.setInteger("id", id).list();
			transaction.commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			borrowEquipment = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return borrowEquipment;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Borrow> getAll() {
		List<Borrow> category = new ArrayList<Borrow>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			category = session.createQuery("from Borrow").list();
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
	public void addListBorrow(BorrowDTO borrowDto) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			Borrow borrow = new Borrow();
			transaction = session.beginTransaction();
			/*borrow.setEmployee((Employee) session.createQuery("select e from Employee e where e.employeeId=:id")
					.setString("id", borrowDto.getEmployeeId()).uniqueResult());*/
			borrow.setUser((User) session.createQuery("select u from User u where u.employeeId=:id").setString("id", borrowDto.getEmployeeId()).uniqueResult());
			borrow.setId(borrowDto.getId());
			borrow.setDateBorrow(borrowDto.getDateBorrow());
			borrow.setDateReturnback(borrowDto.getDateReturnback());
			borrow.setQuantity(borrowDto.getQuantity());
			borrow.setEquipment(borrowDto.getEquipment());
			borrow.setStatus(borrowDto.isStatus());
			session.save(borrow);
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
	public void updateListBorrow(Borrow borrow) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(borrow);
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
	public Borrow getListBorrow(int id) {
		Borrow borrow = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			borrow = (Borrow) session.createQuery("select c from Borrow c where c.id =:id").setInteger("id", id).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			borrow = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return borrow;
	}

	@Override
	public void deleteBorow(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(getListBorrow(id));
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Borrow> getUserBorrow(String username) {
		List<Borrow> borrow = new ArrayList<Borrow>();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			borrow =  session.createQuery("select c from Borrow c where c.user.username =:username").setString("username", username).list();
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			borrow = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return borrow;
	}

	

}
