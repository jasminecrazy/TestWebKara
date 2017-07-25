package demo.service;

import java.util.List;

import demo.entity.Author;

public interface AuthorService {
	public List<Author> findAllAuthor();

	public Author getAuthor(int id);

	public void deleteAuthor(int id);

	public void addAuthor(Author author);

	public void updateAuthor(Author author);
}
