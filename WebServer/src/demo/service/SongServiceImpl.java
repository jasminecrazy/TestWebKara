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

}
