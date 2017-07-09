package demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.AlbumDao;
import demo.entity.Album;

@Service("AlbumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {
	@Autowired
	private AlbumDao albumDao;

	@Override
	public List<Album> findAllAlbum() {

		return albumDao.findAllAlbum();
	}

	@Override
	public Album getAlbum(int id) {
			return albumDao.getAlbum(id);
	}

	@Override
	public void deleteAblum(int id) {
		albumDao.deleteAblum(id);

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
