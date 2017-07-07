package demo.service;

import java.util.List;

import demo.entity.Vn;

public interface SongService {
	public List<Vn> findAll();

	public Vn find(String songname);

	public void create(Vn song);

	public void delete(Vn song);

	public void update(Vn song);

	public List<Vn> search(String keyword);
}
