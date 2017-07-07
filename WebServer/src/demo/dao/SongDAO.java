package demo.dao;

import java.util.List;

import demo.entity.Vn;

public interface SongDAO {
	public List<Vn> findAllSong();

	public Vn getSong(int id);

	public void deleteSong(int id);

	public void addSong(Vn song);

	public void updateSong(Vn song);
}
