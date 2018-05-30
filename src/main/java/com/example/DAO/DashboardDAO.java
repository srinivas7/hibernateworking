package com.example.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.example.demo.HibernateUtil;
import com.example.model.UserDashBoard;

@Component
public class DashboardDAO {
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	public ArrayList getDashBoardData(int userId){
		ArrayList<UserDashBoard> dashBoardData = new ArrayList<UserDashBoard>();

		session.beginTransaction();
        List<UserDashBoard> userDashBoard = session.createQuery("from UserDashBoard").list();
		session.getTransaction().commit();
		
        ListIterator<UserDashBoard> li = userDashBoard.listIterator();
        
        while(li.hasNext()) {
        	dashBoardData.add(li.next());
        }
        
		return dashBoardData;
	}
}
