package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.User;

public interface UserService {

	User findByName(String userName);

}
