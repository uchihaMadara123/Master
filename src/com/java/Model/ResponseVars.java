package com.java.Model;

import net.sf.json.JSONObject;

public class ResponseVars {

	private String status;
	private int statusCode;
	private String errorMessage;
	private JSONObject jsonData ;
	public JSONObject getJsonData() {
		return jsonData;
	}
	public void setJsonData(JSONObject jsonData) {
		this.jsonData = jsonData;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
