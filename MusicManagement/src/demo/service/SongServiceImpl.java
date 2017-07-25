package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.SongDAO;
import demo.entity.Songs;

@Service("SongService")
@Transactional
public class SongServiceImpl implements SongService{
	@Autowired
private SongDAO songDao;
	@Override
	public List<Songs> findAllSongs() {
	return songDao.findAllSongs();
	}

	@Override
	public Songs getSongs(int id) {
	return songDao.getSongs(id);
	}

	@Override
	public void deleteSongs(int id) {
		songDao.deleteSongs(id);
		
	}

	@Override
	public void addSongs(Songs song) {
		songDao.addSongs(song);
		
	}

	@Override
	public void updateSongs(Songs song) {
		songDao.updateSongs(song);
		
	}

}
