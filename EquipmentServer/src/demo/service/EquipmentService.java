package demo.service;

import java.util.List;

import demo.entity.Equipment;

public interface EquipmentService {
	public List<Equipment> getAllEquipment();

	public Equipment getEquipment(int id);

	public void deleteEquipment(int id);

	public void addEquipment(Equipment equipment);

	public void updateEquipment(Equipment equipment);
}
