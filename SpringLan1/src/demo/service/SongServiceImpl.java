package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.SongDao;
import demo.entity.Vn;
@Service("SongService")
@Transactional
public class SongServiceImpl implements SongService{
	@Autowired
private SongDao songDao;
	@Override
	public List<String> search(String songName) {
		// TODO Auto-generated method stub
		return songDao.search(songName);
	}
	@Override
	public List<Vn> getSongVol(int id) {
	
		return songDao.getSongVol(id);
	}
	@Override
	public List<Vn> getAlbumSong(int id) {
		
		return songDao.getAlbumSong(id);
	}
	@Override
	public Vn getSong(int id) {
		
		return songDao.getSong(id);
	}

}
