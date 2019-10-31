package com.example.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.WaterTank;
import com.example.service.TankService;

@RestController
@RequestMapping("/api")
public class TankRestController {

	@Autowired
	private TankService tankService;
		
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	//@RequestMapping("/")
	//Route will Map to http://locahost:port/api/ 
	@GetMapping("/")
	public String welcome() {
		return "Water Tank App! Ver 4.0";
	}
	
	//Route will Map to http://locahost:port/api/tank/add
	//@RequestMapping(value = "/add", method = RequestMethod.POST)
	@PostMapping("/tank/add")
	public List addTank(@RequestBody WaterTank wt) {
		return tankService.addTank(wt);
		
	}
	//http://locahost:port/api/tank/get/all
	@GetMapping("/tank/get/all")
	public List getAllTanks() {
		return tankService.getAllTanks();
	}
	
	@GetMapping("/tank/get/tank/{id}")
	public WaterTank getTankById(@PathVariable Long id) {
		return tankService.getTankById(id);
	}
	
	@GetMapping("/tank/get/location/{loc}")
	public List<WaterTank> getTankByLocation(@PathVariable String loc){
		return tankService.getTankByLocation(loc);
	}
	
	@GetMapping("/tank/get/location/endswith/{loc}")
	public List<WaterTank> getTankByLocationEndsWith(@PathVariable String loc){
		return tankService.getTankByLocationEndsWith(loc);
	}
	
	@GetMapping("/tank/get/location/contain/{loc}")
	public List<WaterTank> getTankByLocationContaining(@PathVariable String loc){
		return tankService.getTankByLocationContaining(loc);
	}
	
	@PostMapping("/tank/update/{id}")
	public List updateById(@PathVariable Long id, @RequestBody WaterTank wt) {
		return tankService.updateById(id, wt);
	}
	
	@DeleteMapping("/tank/delete/{id}")
	public List deleteTankById(@PathVariable Long id) {
		return tankService.deleteTankById(id);
	}
	
	

}
