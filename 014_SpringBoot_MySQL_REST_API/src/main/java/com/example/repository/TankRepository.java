package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.WaterTank;

public interface TankRepository extends JpaRepository<WaterTank, Long> {

	
	List<WaterTank>  findByLocation(String loc);
	
	//:varaible_name
	//%variable_name%
	//below query will look for location ending with 'ar'
	@Query("from WaterTank wt where wt.location like %?1")
	List<WaterTank> findByLocationEndsWith(String loc); 
	
	//below query will look for location containing 'ar'
	@Query("from WaterTank wt where wt.location like %:loc%")
	List<WaterTank> findByLocationContaining(String loc); 
	
}
