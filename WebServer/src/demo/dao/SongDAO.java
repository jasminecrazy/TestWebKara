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

	public List<Vn> getHighLightSong();

	public List<Vn> getFavoriteSong();

	public List<Vn> getNewestSong();

	public List<Vn> getVolSong(int id);

	public List<Vn> getSongSixNumber();

	public List<Vn> searchSong(String keyword);

	public List<Vn> searchLyricSong(String lyric);

	public List<Vn> searchSongSixNumber(String songName);

}
