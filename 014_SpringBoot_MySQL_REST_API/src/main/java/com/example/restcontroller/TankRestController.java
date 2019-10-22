package com.example.restcontroller;

import java.util.List;

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
@RequestMapping("/watertank/api/v1")
public class TankRestController {

	@Autowired
	private TankService tankService;
		
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	//@RequestMapping("/")
	@GetMapping("/")
	public String welcome() {
		return "Water Tank App! Ver 4.0";
	}
	
	//@RequestMapping(value = "/add", method = RequestMethod.POST)
	@PostMapping("/add")
	public List addTank(@RequestBody WaterTank wt) {
		return tankService.addTank(wt);
		
	}
	
	@GetMapping("/all")
	public List getAllTanks() {
		return tankService.getAllTanks();
	}
	
	@GetMapping("/tank/{id}")
	public WaterTank getTankById(@PathVariable Long id) {
		return tankService.getTankById(id);
	}
	
	@PostMapping("/update/{id}")
	public List updateById(@PathVariable Long id, @RequestBody WaterTank wt) {
		return tankService.updateById(id, wt);
	}
	
	@DeleteMapping("/delete/{id}")
	public List deleteTankById(@PathVariable Long id) {
		return tankService.deleteTankById(id);
	}
	

}
