package demo.service;

import java.util.List;

import demo.entity.Album;
import demo.entity.Author;

public interface AlbumService {
	public List<Album> findAllAlbum();

	public Album getAlbum(int id);

	public void deleteAlbum(int id);

	public void addAlbum(Album album);

	public void updateAlbum(Album album);

	
}
