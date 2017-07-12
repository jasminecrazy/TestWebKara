package demo.service;

import java.util.List;

import demo.entity.Album;
import demo.entity.Vn;
import demo.entity.Volume;

public interface SongService {
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
}
