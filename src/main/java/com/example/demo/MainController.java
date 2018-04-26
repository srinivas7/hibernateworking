package com.example.demo;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Album;
import com.example.model.Emp;
import com.example.model.Image;
import com.example.model.UserInfo;

@RestController
public class MainController {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		try {
			Emp emp1 = new Emp(1,"srinivas");
			Album album = new Album(112, "second album");
			UserInfo userInfo = new UserInfo(3434,"new user");
			
			Image image = new Image(555,"first image");
			image.setAlbum(album);
			
			album.setUserInfo(userInfo);
			
			session.beginTransaction();
			//session.save(emp1);
			//session.save(album);
			session.save(image);
			session.getTransaction().commit();
			session.close();
			//HibernateUtil.shutdown();

		}catch (Exception e) {
			 e.printStackTrace();
		}
		return "test route";
	}
	
	@RequestMapping(value = "/getAlbums", method = RequestMethod.GET)
	public String getAlbums() {
		return "albums";
	}
	

	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public int addEmp(@RequestBody Emp emp) {
		System.out.println("from /addEmp");
		session.beginTransaction();
		int id = (int)session.save(emp);
		session.getTransaction().commit();
		session.close();
		return id;
	}


}
