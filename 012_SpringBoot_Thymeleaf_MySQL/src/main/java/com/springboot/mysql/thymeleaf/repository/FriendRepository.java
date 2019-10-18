package com.springboot.mysql.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mysql.thymeleaf.entity.FriendEntity;

@Repository
public interface FriendRepository extends CrudRepository<FriendEntity, Integer>{
	//All crud implementations are automatically done!
	//If required you can define custom implemetations as well!
}
