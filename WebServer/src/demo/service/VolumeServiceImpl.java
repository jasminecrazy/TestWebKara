package demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.VolumeDao;
import demo.entity.Volume;
@Service("VolumeService")
@Transactional
public class VolumeServiceImpl implements VolumeService{
	@Autowired
private VolumeDao volumeDao;
	@Override
	public List<Volume> findAllVol() {
		return volumeDao.findAllVol();
	}

	@Override
	public Volume getVol(int id) {
		return volumeDao.getVol(id);
	}

	@Override
	public void deleteVol(int id) {
		volumeDao.deleteVol(id);
		
	}

	@Override
	public void addVol(Volume volume) {
		volumeDao.addVol(volume);
		
	}

	@Override
	public void updateVol(Volume volume) {
		volumeDao.updateVol(volume);
		
	}

}
