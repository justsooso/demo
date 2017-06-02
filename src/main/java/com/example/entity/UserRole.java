package com.example.entity;

public enum UserRole {
	USER, ADMIN, VIP;
	
	public static UserRole getRole(Integer i){
		switch (i) {
		case 1:
			return UserRole.ADMIN;
		case 2:
			return UserRole.USER;
		default:
			return UserRole.VIP;
		}
	}
}
