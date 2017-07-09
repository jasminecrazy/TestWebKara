package demo.dao;

import java.util.List;

import demo.entity.Album;
import demo.entity.Vn;
import demo.entity.Volume;

public interface SongDAO {
	public List<Vn> findAllSong();

	public Vn getSong(int id);

	public void deleteSong(int id);

	public void addSong(Vn song);

	public void updateSong(Vn song);

	public List<Volume> getListVol();

	public List<Album> getListAlbum();
}
