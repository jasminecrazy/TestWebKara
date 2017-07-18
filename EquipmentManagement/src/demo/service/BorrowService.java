package demo.service;

import java.util.List;

import demo.entity.Borrow;

public interface BorrowService {
	public List<Borrow> getUserBorow(String username);
}
