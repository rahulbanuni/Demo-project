package com.nit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoginDaoImpl  implements UserLoginDao{
	
	
	@Autowired
	private SessionFactory sessionFactory;


     public boolean checkLogin(String userName, String userPassword){
			
			boolean userFound = false;
			//Query using Hibernate Query Language
			String SQL_QUERY =" from Users as o where o.userName=? and o.userPassword=?";
			Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,userPassword);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}

		
			return userFound;              
     }
}


