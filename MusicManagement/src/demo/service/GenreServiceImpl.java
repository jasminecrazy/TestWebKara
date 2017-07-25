package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.GenreDAO;
import demo.entity.Genre;

@Service("GenreService")
@Transactional
public class GenreServiceImpl implements GenreService {
	@Autowired
private GenreDAO genreDao;
	@Override
	public List<Genre> findAllGenre() {
		return genreDao.findAllGenre();
	}

	@Override
	public Genre getGenre(int id) {
		return genreDao.getGenre(id);
	}

	@Override
	public void deleteGenre(int id) {
		genreDao.deleteGenre(id);
		
	}

	@Override
	public void addGenre(Genre genre) {
		genreDao.addGenre(genre);
		
	}

	@Override
	public void updateGenre(Genre genre) {
		genreDao.updateGenre(genre);
		
	}

}
