package demo.dao;

import java.util.List;

import demo.entity.Genre;

public interface GenreDAO {
	public List<Genre> findAllGenre();

	public Genre getGenre(int id);

	public void deleteGenre(int id);

	public void addGenre(Genre genre);

	public void updateGenre(Genre genre);

	
}
