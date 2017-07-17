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

@Repository("BorrowDAO")
public class BorrowDAOImpl implements BorrowDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Borrow getEquipment(int id) {
		Borrow borrowEquipment = new Borrow();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			borrowEquipment = (Borrow) session.createQuery("select b from Borrow b where b.equipment.id=:id")
					.setInteger("id", id).uniqueResult();
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
			borrow.setEmployee((Employee) session.createQuery("select e from Employee e where e.employeeId=:id")
					.setString("id", borrowDto.getEmployeeId()).uniqueResult());
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

}
