package demo.dao;

import java.util.List;

import demo.entity.Album;

public interface AlbumDao {
	public List<Album> findAllAlbum();

	public Album getAlbum(int id);

	public void deleteAblum(int id);

	public void addAlbum(Album album);

	public void updateAlbum(Album album);
}
