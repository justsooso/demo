package com.example.dao;

import org.springframework.data.repository.Repository;

import com.example.entity.User;

public interface UserDao extends Repository<User, Integer>{
	void save(User user);

	User findByUsername(String userName);
}
