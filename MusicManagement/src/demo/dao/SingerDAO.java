package demo.dao;

import java.util.List;

import demo.entity.Singer;

public interface SingerDAO {
	public List<Singer> findAllSinger();

	public Singer getSinger(int id);

	public void deleteSinger(int id);

	public void addSinger(Singer singer);

	public void updateSinger(Singer singer);

	
}
