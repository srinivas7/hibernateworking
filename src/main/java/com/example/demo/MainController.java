package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserLogin;
import com.example.DAO.AlbumsDAO;
import com.example.DAO.AlbumsDAOImpl;
import com.example.DAO.DashboardDAO;
import com.example.DAO.UserLoginCheckDAO;
import com.example.model.Album;
import com.example.model.Emp;
import com.example.model.Image;
import com.example.model.UserDashBoard;
import com.example.model.UserInfo;

@RestController
public class MainController {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	@Autowired
	AlbumsDAOImpl albumsDaoImpl;
	
	@Autowired
	UserLoginCheckDAO userLoginCheck;
	
	@Autowired
	DashboardDAO dashboard;
	
	EntityManager em;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		try {
			System.out.println("asdf");
			Emp emp1 = new Emp(1,"srinivas");
			Album album = new Album(112, "second album");
			UserInfo userInfo = new UserInfo(3434,"new user");
			
			Image image = new Image(555,"first image");
			image.setAlbum(album);
			
			album.setUserInfo(userInfo);
			
			session.beginTransaction();
			session.save(image);
			session.getTransaction().commit();
			HibernateUtil.shutdown();

		}catch (Exception e) {
			 e.printStackTrace();
		}
		return "test route";
	}
	
	@RequestMapping(value = "/getAlbums/{userId}", method = RequestMethod.GET, produces="application/json")
	public List<Album> getAlbums(@PathVariable("userId") int userId) {
		return albumsDaoImpl.getAlbums(userId);
	}
	
	@RequestMapping(value = "/getAlbumInfo/{albumId}", method = RequestMethod.GET, produces="application/json")
	public Map getAlbumInfo(@PathVariable("albumId") int albumId) {
		return albumsDaoImpl.getAlbumData(albumId);
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
	
	
	@Consumes({MediaType.APPLICATION_JSON})
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity login(@RequestBody UserLogin userLogin) {
                boolean login;
                login = userLoginCheck.checkUserLogin(userLogin);
                
                return new ResponseEntity(login, HttpStatus.OK);
	}
	
	@RequestMapping(value="/dashBoardInfo/{userId}", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<UserDashBoard>> dashBoardInfo(@PathVariable int userId) {
		System.out.println("use id is..."+ userId);
		ArrayList<UserDashBoard> al = dashboard.getDashBoardData(userId);
		
		return new ResponseEntity(al, HttpStatus.OK);
		
	}
	
	@Consumes({MediaType.APPLICATION_JSON})
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ResponseEntity signup(@RequestBody UserLogin userLogin) {
		
		boolean login = false;
		try{
			 login = userLoginCheck.createUser(userLogin);
		     return new ResponseEntity(login, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity(login, HttpStatus.OK);
		}
		
       
        
	}

}
