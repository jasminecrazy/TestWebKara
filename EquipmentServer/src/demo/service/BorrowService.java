package demo.service;

import java.util.List;

import demo.entity.Borrow;

public interface BorrowService {
	public List<Borrow> getAll();

	public Borrow getEquipment(int id);

	public void addListBorrow(Borrow borrow);

	public void updateListBorrow(Borrow borrow);
}
