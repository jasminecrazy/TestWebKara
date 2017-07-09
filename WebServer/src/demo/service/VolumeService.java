package demo.service;

import java.util.List;

import demo.entity.Volume;

public interface VolumeService {
	public List<Volume> findAllVol();

	public Volume getVol(int id);

	public void deleteVol(int id);

	public void addVol(Volume volume);

	public void updateVol(Volume volume);
}
