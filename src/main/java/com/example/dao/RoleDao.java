package com.example.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.example.entity.Role;

public interface RoleDao extends Repository<Role, Integer>{

	List<Role> findByUserId(Integer userid);

	
}
