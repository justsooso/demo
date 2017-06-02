package com.example.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="_user",indexes={@Index(columnList="id")})
public class User implements Serializable{
	
	
	
	public User() {}
	
	public User(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.id = user.getId();
    }
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",precision=10)
	private Integer id;
	
	@Column(name="username",length=100)
	private String username;
	
	@Column(name="password",length=100)
	private String password;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
