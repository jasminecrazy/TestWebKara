package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.SongDao;
import demo.entity.Vn;
@Service("songService")
@Transactional
public class SongServiceImpl implements SongService{
	@Autowired
private SongDao songDao;
	@Override
	public List<Vn> findAll() {
	
		return songDao.findAll();
	}

	@Override
	public Vn find(String songname) {
		
		return songDao.find(songname);
	}

	@Override
	public void create(Vn song) {
		songDao.create(song);
		
	}

	@Override
	public void delete(Vn song) {
		songDao.delete(song);
		
	}

	@Override
	public void update(Vn song) {
		songDao.update(song);
		
	}

	@Override
	public List<Vn> search(String keyword) {
	
		return songDao.search(keyword);
	}

}
