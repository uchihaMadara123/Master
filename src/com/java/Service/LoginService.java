package com.java.Service;

import com.java.Model.Login;
import com.java.Model.ResponseVars;

public interface LoginService {
 public ResponseVars checkValidUser(Login requestParams);
}
