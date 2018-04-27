package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {
	@Id
	@Column(name = "")
	int image_id;
	
	@Column(name = "")
	String image_name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "album_id")
	Album album;
	
	public Image() {}
	
	public Image(int image_id, String image_name) {
		this.image_id = image_id;
		this.image_name = image_name;
	}

	public int getImage_id() {
		return image_id;
	}

	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
}
