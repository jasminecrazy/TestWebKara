package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.BorrowDAO;
import demo.entity.Borrow;

@Service("BorrowService")
@Transactional
public class BorrowServiceImpl implements BorrowService{
	@Autowired
private BorrowDAO borrowDao;
	@Override
	public Borrow getEquipment(int id) {
		// TODO Auto-generated method stub
		return borrowDao.getEquipment(id);
	}
	@Override
	public List<Borrow> getAll() {
		// TODO Auto-generated method stub
		return borrowDao.getAll();
	}
	@Override
	public void addListBorrow(Borrow borrow) {
		borrowDao.addListBorrow(borrow);
		
	}
	@Override
	public void updateListBorrow(Borrow borrow) {
		borrowDao.updateListBorrow(borrow);
		
	}

}
