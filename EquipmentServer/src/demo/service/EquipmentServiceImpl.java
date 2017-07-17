package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.EquipmentDAO;
import demo.entity.Equipment;

@Service("EquipmentService")
@Transactional
public class EquipmentServiceImpl  implements EquipmentService{
	@Autowired
private EquipmentDAO equipmentDao;
	@Override
	public List<Equipment> getAllEquipment() {
		return equipmentDao.getAllEquipment();
	}

	@Override
	public Equipment getEquipment(int id) {
		return equipmentDao.getEquipment(id);
	}

	@Override
	public void deleteEquipment(int id) {
		equipmentDao.deleteEquipment(id);
		
	}

	@Override
	public void addEquipment(Equipment equipment) {
		equipmentDao.addEquipment(equipment);
		
	}

	@Override
	public void updateEquipment(Equipment equipment) {
		equipmentDao.updateEquipment(equipment);
		
	}

}
