package demo.dao;

import java.util.List;

import demo.dto.BorrowDTO;
import demo.entity.Borrow;
import demo.entity.Category;

public interface BorrowDAO {
	public List<Borrow> getAll();
	public Borrow getEquipment(int id);

	public void addListBorrow(BorrowDTO borrow);

	public void updateListBorrow(Borrow borrow);
}
