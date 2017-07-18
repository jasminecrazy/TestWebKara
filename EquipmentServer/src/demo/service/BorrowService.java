package demo.service;

import java.util.List;

import demo.dto.BorrowDTO;
import demo.entity.Borrow;

public interface BorrowService {
	public List<Borrow> getAll();

	public List<Borrow> getEquipment(int id);

	public void addListBorrow(Borrow borrow);

	public void updateListBorrow(Borrow borrow);

	void addListBorrow(BorrowDTO borrow);

	public Borrow getListBorrow(int id);

	public void deleteBorow(int id);

	public List<Borrow> getUserBorrow(String username);

}
