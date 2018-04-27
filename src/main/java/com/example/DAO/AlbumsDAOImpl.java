package com.example.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.example.demo.HibernateUtil;
import com.example.model.Album;
import com.example.model.Image;

@Component
public class AlbumsDAOImpl implements AlbumsDAO {

	@Override
	public void insertAlbumData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Album> getAlbums(int userId) {
		List<Album> albumsList = new ArrayList<Album>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query<Album> query = session.createQuery("from Album where user_id="+userId);
		List<Album> list = query.list();
		for (ListIterator<Album> iterator = list.listIterator(); iterator.hasNext(); ) {
			Album album = iterator.next();
			albumsList.add(album);
		}
		
		session.getTransaction().commit();
		session.close();
		return albumsList;
	}
	
	@Override
	public Map getAlbumData(int albumId) {
		Map<String,Object> albumData = new HashMap<String, Object>();
		List<Album> albumsList = new ArrayList<Album>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query<Album> albumInfo = session.createQuery("from Album where album_id="+albumId);
		Query<Image> imagesInfo = session.createQuery("from Image where album_id="+albumId);
		
		List<Album> albumList = albumInfo.list();
		for (ListIterator<Album> iterator = albumList.listIterator(); iterator.hasNext(); ) {
			Album album = iterator.next();
			albumsList.add(album);
		}
		
		List<Image> imagesList = imagesInfo.list();
		for (ListIterator<Image> imagesIterator = imagesList.listIterator(); imagesIterator.hasNext(); ) {
			Image image = imagesIterator.next();
			imagesList.add(image);
		}
		
		albumData.put("albumsList", albumsList);
		albumData.put("imagesList", imagesList);
		
		session.getTransaction().commit();
		session.close();
		return albumData;
	}


}
