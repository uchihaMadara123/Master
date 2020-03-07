package com.java.ServiceImpl;

import com.java.Constants.Constants;
import com.java.DAO.LoginDAO;
import com.java.DAOImpl.LoginDAOImpl;
import com.java.Model.Login;
import com.java.Model.ResponseVars;
import com.java.Service.LoginService;

public class LoginServiceImpl implements LoginService {
LoginDAO loginDao = null;
	@Override
	public ResponseVars checkValidUser(Login requestParams) {
		ResponseVars response = new ResponseVars();
		loginDao = new LoginDAOImpl();
		if(this.loginDao.isDBConnectionAvailable()){
			response = this.loginDao.checkValidUser(requestParams);
			this.loginDao.closeConnection();
		}else{
			response.setStatus(Constants.DB_NOT_AVAILABLE);
			response.setStatusCode(Constants.DB_NOT_AVAILABLE_CODE);
		}
		return response;
	}
	
}
