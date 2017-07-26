package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.AlbumDAO;
import demo.entity.Album;

@Service("AlbumService")
@Transactional
public class AlbumServiceImpl implements AlbumService{
	@Autowired
private AlbumDAO albumDao;
	@Override
	public List<Album> findAllAlbum() {
		return albumDao.findAllAlbum();
		}

	@Override
	public Album getAlbum(int id) {
		
		return albumDao.getAlbum(id);
	}

	@Override
	public void deleteAlbum(int id) {
		albumDao.deleteAlbum(id);
		
	}

	@Override
	public void addAlbum(Album album) {
		albumDao.addAlbum(album);
		
	}

	@Override
	public void updateAlbum(Album album) {
		albumDao.updateAlbum(album);
		
	}

	
}
