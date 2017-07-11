package demo.dao;

import java.util.List;

import demo.entity.Vn;

public interface SongDao {
	public List<String> search(String songName);

	public List<Vn> getSongVol(int id);

	public List<Vn> getAlbumSong(int id);

	public Vn getSong(int id);
}
