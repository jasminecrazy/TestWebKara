package demo.dao;

import java.util.List;

import demo.entity.Songs;


public interface SongDAO {
	public List<Songs> findAllSongs();

	public Songs getSongs(int id);

	public void deleteSongs(int id);

	public void addSongs(Songs song);

	public void updateSongs(Songs song);
}
