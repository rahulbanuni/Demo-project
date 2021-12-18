package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nit.dao.UserLoginDao;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService{

	
	 @Autowired
	 private UserLoginDao loginDAO;

	
		@Override
		@Transactional
       public boolean checkLogin(String userName, String userPassword){
              System.out.println("In Service class...Check Login");
              return loginDAO.checkLogin(userName, userPassword);
       }
}
