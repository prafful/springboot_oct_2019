package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TankDao;
import com.example.entity.WaterTank;

@Service("tankService")
public class TankService {
	
	@Autowired
	private TankDao tankDao;

	public List<WaterTank> addTank(WaterTank wt) {
		// TODO Auto-generated method stub
		return tankDao.addTank(wt);
	}

	public List getAllTanks() {
		// TODO Auto-generated method stub
		return tankDao.getAllTanks();
	}

	public WaterTank getTankById(Long id) {
		// TODO Auto-generated method stub
		return tankDao.getTankById(id);
	}

	public List updateById(Long id, WaterTank wt) {
		// TODO Auto-generated method stub
		return tankDao.updateById(id, wt);
	}

	public List deleteTankById(Long id) {
		// TODO Auto-generated method stub
		return tankDao.deleteTankById(id);
	}

}
