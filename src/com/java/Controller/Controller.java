package com.java.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.java.Model.Login;
import com.java.Model.ResponseVars;
import com.java.Service.LoginService;
import com.java.ServiceImpl.LoginServiceImpl;

@Path("/v1")
public class Controller {
	LoginService loginService = null;
	@Path("/checkValidUser")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkValidUser(Login requestParams) {
		loginService = new LoginServiceImpl();
		ResponseVars responseVars = this.loginService.checkValidUser(requestParams);
		return Response.status(200).entity(responseVars).build();
	}
}