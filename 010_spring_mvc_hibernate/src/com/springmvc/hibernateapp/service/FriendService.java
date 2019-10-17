package com.springmvc.hibernateapp.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.hibernateapp.dao.FriendDao;
import com.springmvc.hibernateapp.entity.FriendEntity;

@Service("friendService")
public class FriendService {
	
	@Autowired
	private FriendDao friendDao;

	@Transactional
	public void addNewFriend(FriendEntity fe) {
		// TODO Auto-generated method stub
		friendDao.addNewFriend(fe);
	}

	public List<FriendEntity> getAllFriends() {
		// TODO Auto-generated method stub
		return friendDao.getAllFriends();
	}

	public void deleteFriend(Integer id) {
		// TODO Auto-generated method stub
		friendDao.deleteFriend(id);
	}

}
