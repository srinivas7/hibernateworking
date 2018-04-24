package com.example.demo;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Emp;

@RestController
public class MainController {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		try {
			Emp emp1 = new Emp(1,"srinivas");
			session.beginTransaction();
			session.save(emp1);
			session.getTransaction().commit();
			session.close();
			//HibernateUtil.shutdown();

		}catch (Exception e) {
			 e.printStackTrace();
		}
		return "test route";
	}

}
