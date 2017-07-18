package demo.dao;

import java.util.List;

import demo.dto.BorrowDTO;
import demo.entity.Borrow;

public interface BorrowDAO {
	public List<Borrow> getAll();

	public List<Borrow> getEquipment(int id);

	public void addListBorrow(BorrowDTO borrow);

	public void updateListBorrow(Borrow borrow);

	public Borrow getListBorrow(int id);

	public void deleteBorow(int id);

	public List<Borrow> getUserBorrow(String username);

	

}
