package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.BorrowDAO;
import demo.entity.Borrow;
@Service("BorrowService")
@Transactional
public class BorrowServiceImpl implements BorrowService {
	@Autowired
private BorrowDAO borrowDao;
	@Override
	public List<Borrow> getUserBorow(String username) {
		
		return borrowDao.getUserBorow(username);
	}

}
