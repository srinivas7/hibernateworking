package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album {
	
	@Id
	@Column(name="album_id")
	private int id;
	
	@Column(name="album_name")
	private String name;
	
	
	@ManyToOne(optional = false, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private UserInfo userInfo;
	
	public Album() {}
	
	public Album(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
