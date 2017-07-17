package demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.SongDAO;
import demo.entity.Album;
import demo.entity.Vn;
import demo.entity.Volume;

@Service("SongService")
@Transactional 
public class SongServiceImpl implements SongService {
	@Autowired
	private SongDAO songDao;

	
	public List<Vn> findAllSong() {
		
		return songDao.findAllSong();
	}

	@Override
	public Vn getSong(int id) {
		// TODO Auto-generated method stub
		return songDao.getSong(id);
	}

	@Override
	public void deleteSong(int id) {
		songDao.deleteSong(id);

	}

	@Override
	public void addSong(Vn song) {
		songDao.addSong(song);

	}

	@Override
	public void updateSong(Vn song) {
		songDao.updateSong(song);

	}

	@Override
	public List<Volume> getListVol() {
		
		return songDao.getListVol();
	}

	@Override
	public List<Album> getListAlbum() {
	
		return songDao.getListAlbum();
	}

	@Override
	public List<Vn> getHighLightSong() {
		
		return songDao.getHighLightSong();
	}

	@Override
	public List<Vn> getFavoriteSong() {
		
		return songDao.getFavoriteSong();
	}

	@Override
	public List<Vn> getNewestSong() {
		
		return songDao.getNewestSong();
	}

	@Override
	public List<Vn> getVolSong(int id) {
		
		return songDao.getVolSong(id);
	}

	@Override
	public List<Vn> getSongSixNumber() {
	
		return songDao.getSongSixNumber();
	}

	@Override
	public List<Vn> searchSong(String keyword) {
		
		return songDao.searchSong(keyword);
	}

	@Override
	public List<Vn> searchLyricSong(String lyric) {
	
		return songDao.searchLyricSong(lyric);
	}

	@Override
	public List<Vn> searchSongSixNumber(String songName) {
	
		return songDao.searchSongSixNumber(songName);
	}

}
