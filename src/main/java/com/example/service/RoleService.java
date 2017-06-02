package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Role;
import com.example.entity.User;


public interface RoleService {

	List<Role> getRoleByUser(User user);

}
