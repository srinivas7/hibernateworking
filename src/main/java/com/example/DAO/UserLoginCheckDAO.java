package com.example.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.HibernateUtil;
import com.example.model.UserLogin;

@Component
public class UserLoginCheckDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	//Transaction tr = session.beginTransaction();
	EntityManager em;
	
	@Transactional
	public boolean checkUserLogin(UserLogin userLoginData){
		//Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
        List userLoginInfo = session.createQuery("from UserLogin").list();
		System.out.println("user login info is..."+ userLoginInfo);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();
		String enteredUN = userLoginData.getUserName();
        String enteredPWD = userLoginData.getPwd();
        
        
		return true;
	}
}
