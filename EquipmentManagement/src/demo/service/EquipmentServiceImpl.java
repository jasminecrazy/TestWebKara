package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.EquipmentDAO;
import demo.entity.Equipment;

@Service("EquipmentService")
@Transactional
public class EquipmentServiceImpl implements EquipmentService {
	@Autowired
	private EquipmentDAO equipmentDao;

	@Override
	public Equipment getEquipment(int id) {
		
		return equipmentDao.getEquipment(id);
	}

}
