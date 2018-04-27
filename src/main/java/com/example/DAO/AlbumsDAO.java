package com.example.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.model.Album;

@Component
public interface AlbumsDAO {
	
	//public List<Album> getAlbumData();
	public Map getAlbumData(int albumId);
	public void insertAlbumData();
	public List<Album> getAlbums(int userId);
	
}
