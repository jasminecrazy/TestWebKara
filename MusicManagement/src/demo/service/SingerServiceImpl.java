package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.SingerDAO;
import demo.entity.Singer;

@Service("SingerService")
@Transactional
public class SingerServiceImpl implements SingerService{
	@Autowired
private SingerDAO singerDao;
	@Override
	public List<Singer> findAllSinger() {
		return singerDao.findAllSinger();
	}

	@Override
	public Singer getSinger(int id) {
		return singerDao.getSinger(id);
	}

	@Override
	public void deleteSinger(int id) {
		singerDao.deleteSinger(id);
		
	}

	@Override
	public void addSinger(Singer singer) {
		singerDao.addSinger(singer);
		
	}

	@Override
	public void updateSinger(Singer singer) {
		singerDao.updateSinger(singer);
		
	}

	
}
