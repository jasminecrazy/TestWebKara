package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.BorrowDAO;
import demo.dto.BorrowDTO;
import demo.entity.Borrow;

@Service("BorrowService")
@Transactional
public class BorrowServiceImpl implements BorrowService {
	@Autowired
	private BorrowDAO borrowDao;

	@Override
	public List<Borrow> getEquipment(int id) {
		// TODO Auto-generated method stub
		return borrowDao.getEquipment(id);
	}

	@Override
	public List<Borrow> getAll() {
		// TODO Auto-generated method stub
		return borrowDao.getAll();
	}

	@Override
	public void updateListBorrow(Borrow borrow) {
		borrowDao.updateListBorrow(borrow);

	}

	@Override
	public void addListBorrow(BorrowDTO borrow) {
		borrowDao.addListBorrow(borrow);
	}

	@Override
	public void addListBorrow(Borrow borrow) {
		// TODO Auto-generated method stub

	}

	@Override
	public Borrow getListBorrow(int id) {

		return borrowDao.getListBorrow(id);
	}

	@Override
	public void deleteBorow(int id) {
		borrowDao.deleteBorow(id);

	}

	@Override
	public List<Borrow> getUserBorrow(String username) {
		
		return borrowDao.getUserBorrow(username);
	}

	

}
