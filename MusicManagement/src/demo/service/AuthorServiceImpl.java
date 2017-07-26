package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.AuthorDAO;
import demo.entity.Author;

@Service("AuthorService")
@Transactional
public class AuthorServiceImpl implements AuthorService{
	@Autowired
private AuthorDAO authorDao;
	@Override
	public List<Author> findAllAuthor() {
		
		return authorDao.findAllAuthor();
	}

	@Override
	public Author getAuthor(int id) {
		
		return authorDao.getAuthor(id);
	}

	@Override
	public void deleteAuthor(int id) {
		authorDao.deleteAuthor(id);
		
	}

	@Override
	public void addAuthor(Author author) {
		authorDao.addAuthor(author);
		
	}

	@Override
	public void updateAuthor(Author author) {
		authorDao.updateAuthor(author);
		
	}

	
}
