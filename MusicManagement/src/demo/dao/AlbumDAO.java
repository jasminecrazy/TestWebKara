package demo.dao;

import java.util.List;

import demo.entity.Album;


public interface AlbumDAO {
	public List<Album> findAllAlbum();

	public Album getAlbum(int id);

	public void deleteAlbum(int id);

	public void addAlbum(Album album);

	public void updateAlbum(Album album);
}
