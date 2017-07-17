package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entity.Equipment;

@Repository("EquipmentDAO")
public class EquipmentDAOImpl implements EquipmentDAO{
	@Autowired
private SessionFactory sessionFactory;
	@Override
	public Equipment getEquipment(int id) {
		Equipment equipment = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			equipment = (Equipment) session.createQuery("select c from Equipment c where c.id =:id").setInteger("id", id).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			equipment = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return equipment;
	}

}
