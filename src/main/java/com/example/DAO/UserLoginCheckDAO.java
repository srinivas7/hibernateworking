package com.example.DAO;

import java.util.List;
import java.util.ListIterator;

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
	
	public boolean checkUserLogin(UserLogin userLoginData){

		session.beginTransaction();
        List userLoginInfo = session.createQuery("from UserLogin").list();
		session.getTransaction().commit();
		String enteredUN = userLoginData.getUserName();
        String enteredPWD = userLoginData.getPwd();
        
        ListIterator<UserLogin> li = userLoginInfo.listIterator();
        
        while(li.hasNext()) {
        	UserLogin ul = li.next();
        	if(ul.userName.equals(enteredUN) && ul.pwd.equals(enteredPWD)) {
        		return true;
        	}
        }
        
		return false;
	}
}
