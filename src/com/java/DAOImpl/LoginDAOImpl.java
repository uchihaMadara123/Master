package com.java.DAOImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONObject;

import com.java.Constants.Constants;
import com.java.DAO.LoginDAO;
import com.java.Model.Login;
import com.java.Model.ResponseVars;
import com.java.Utils.DBconnection;
import com.java.Utils.SQLQueries;
public class LoginDAOImpl implements LoginDAO {
	Connection dbConnection = DBconnection.getDBconnection();
	@Override
	public boolean isDBConnectionAvailable() {
		return this.dbConnection != null;
	}

	@Override
	public void closeConnection() {
		try {
			this.dbConnection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}

	@Override
	public ResponseVars checkValidUser(Login requestParams) {
		ResponseVars response = new ResponseVars();
		JSONObject responseJsonObject = new JSONObject();
		try (PreparedStatement preparedStatement = this.dbConnection
				.prepareStatement(SQLQueries.GET_ASSOCIATE_NAME_AND_PASSWORD)) {
			preparedStatement.setInt(1, requestParams.getUserId());
			preparedStatement.setString(2, requestParams.getPassword());
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					responseJsonObject.put("associateId",
							resultSet.getInt("associateId"));
					responseJsonObject.put("associateName",
							resultSet.getString("associateName"));
					responseJsonObject.put("password",
							resultSet.getInt("password"));
				}
				if (responseJsonObject.isEmpty()) {
					response.setStatus(Constants.NO_DATA_AVAILABLE);
					response.setStatusCode(Constants.NO_DATA_AVAILABLE_CODE);
					response.setErrorMessage("Invalid User");
				} else {
					response.setStatus(Constants.SUCCESS);
					response.setStatusCode(Constants.SUCCESS_CODE);
					response.setJsonData(responseJsonObject);
				}
			}
		} catch (SQLException sqlException) {
			response.setStatus(Constants.EXCEPTION_RAISED);
			response.setStatusCode(Constants.EXCEPTION_RAISED_CODE);
			response.setErrorMessage(sqlException.getMessage());
		} catch (Exception exception) {
			response.setStatus(Constants.EXCEPTION_RAISED);
			response.setStatusCode(Constants.EXCEPTION_RAISED_CODE);
			response.setErrorMessage(exception.getMessage());
		}
		return response;
	}

}
