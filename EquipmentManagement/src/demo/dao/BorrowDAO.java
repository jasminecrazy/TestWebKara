package demo.dao;

import java.util.List;

import demo.dto.BorrowDTO;
import demo.entity.Borrow;

public interface BorrowDAO {
public List<Borrow> getUserBorow(String username);
}
