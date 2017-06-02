package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.RoleDao;
import com.example.entity.Role;
import com.example.entity.User;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> getRoleByUser(User user) {
		List<Role> roles = roleDao.findByUserId(user.getId());
		return roles;
	}

}
