package demo.service;

import java.util.List;

import demo.entity.Album;
import demo.entity.Author;
import demo.entity.Singer;

public interface SingerService {
	public List<Singer> findAllSinger();

	public Singer getSinger(int id);

	public void deleteSinger(int id);

	public void addSinger(Singer singer);

	public void updateSinger(Singer singer);
}
