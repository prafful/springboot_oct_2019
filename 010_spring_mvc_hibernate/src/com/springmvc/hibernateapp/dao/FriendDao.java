package com.springmvc.hibernateapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.hibernateapp.entity.FriendEntity;

@Repository("friendDao")
public class FriendDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addNewFriend(FriendEntity fe) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			
			session = sessionFactory.getCurrentSession();
			System.out.println("Get Current Session");
		} catch (Exception e) {
		
			session = sessionFactory.openSession();
			System.out.println("Open New Session");
		}
		
		session.save(fe);
		//session.flush();
		//session.close();
		//sessionFactory.close();
		
	}

	public List<FriendEntity> getAllFriends() {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			
			session = sessionFactory.getCurrentSession();
			System.out.println("Get Current Session");
		} catch (Exception e) {
	
			session = sessionFactory.openSession();
			System.out.println("Open New Session");
		}
		Query query = session.createQuery("from FriendEntity");
		List<FriendEntity> allfriends = query.list();
		session.close();
		return allfriends;
	}

}
