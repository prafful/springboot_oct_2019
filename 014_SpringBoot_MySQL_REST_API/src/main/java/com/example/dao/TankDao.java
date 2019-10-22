package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.WaterTank;
import com.example.repository.TankRepository;

@Repository("tankDao")
public class TankDao {
	
	@Autowired
	private TankRepository tankRepository;

	public List<WaterTank> addTank(WaterTank wt) {
		// TODO Auto-generated method stub
		tankRepository.save(wt);
		return tankRepository.findAll();
	}

	public List getAllTanks() {
		// TODO Auto-generated method stub
		return tankRepository.findAll();
	}

	public WaterTank getTankById(Long id) {
		// TODO Auto-generated method stub
		Optional<WaterTank> optionalTank = tankRepository.findById(id);
		WaterTank wt = new WaterTank();
		try {
			wt = optionalTank.get();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("id does not exist!");
		}
		return wt;
		
	}

	public List updateById(Long id, WaterTank wt) {
		// TODO Auto-generated method stub
		WaterTank wtNew = new WaterTank();
		try {
			wtNew = tankRepository.findById(id).get();
		} catch (Exception e) {
			System.out.println("Id is not valid!");
			return tankRepository.findAll();
		}
		wtNew.setCapacity(wt.getCapacity());
		wtNew.setLocation(wt.getLocation());
		tankRepository.saveAndFlush(wtNew);
		return tankRepository.findAll();
	}

	public List deleteTankById(Long id) {
		// TODO Auto-generated method stub
		tankRepository.deleteById(id);
		return tankRepository.findAll();
	}

}
