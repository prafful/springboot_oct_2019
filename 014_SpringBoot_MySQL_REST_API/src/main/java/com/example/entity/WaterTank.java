package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "water_tank")
public class WaterTank {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	@Column(name ="tank_capacity")
	private Long capacity;
	@Column(name ="tank_location")
	private String location;
	
	
	
}
