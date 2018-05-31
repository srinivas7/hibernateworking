package com.example.DAO;

import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.HibernateUtil;
import com.example.model.UserLogin;

@Component
public class UserLoginCheckDAO {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction tx = null;
	
	public boolean checkUserLogin(UserLogin userLoginData){

		session.beginTransaction();
        List userLoginInfo = session.createQuery("from UserLogin").list();
		session.getTransaction().commit();
		String enteredUN = userLoginData.getUserName();
        String enteredPWD = userLoginData.getPwd();
        
        ListIterator<UserLogin> li = userLoginInfo.listIterator();
        
        while(li.hasNext()) {
        	UserLogin ul = li.next();
        	if(ul.userName.equals(enteredUN) && checkPassword(enteredPWD, ul.pwd)) {
        		return true;
        	}
        }
        
		return false;
	}
	
	public boolean createUser(UserLogin userLoginData) {
		tx = session.beginTransaction();
		String hashpwd = hashPassword(userLoginData.getPwd());
		userLoginData.setPwd(hashpwd);
		session.save(userLoginData);
		tx.commit();
		return true;
	}
	
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	private boolean checkPassword(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;
		else
			return false;
	}
}
