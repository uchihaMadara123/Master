package com.java.DAO;

import com.java.Model.Login;
import com.java.Model.ResponseVars;

public interface LoginDAO {
	public boolean isDBConnectionAvailable();
	public void closeConnection();
	public ResponseVars checkValidUser(Login requestParams);
}
