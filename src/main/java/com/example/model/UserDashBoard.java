package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "userdashboard")
public class UserDashBoard {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int postId;
	char postType;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public char getPostType() {
		return postType;
	}
	public void setPostType(char postType) {
		this.postType = postType;
	}
	
	
}
