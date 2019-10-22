package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.WaterTank;

public interface TankRepository extends JpaRepository<WaterTank, Long> {

}
