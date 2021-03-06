package com.daweda.webservices.rest;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

//http://localhost:8080/daweda-rest/rest/message/sdfdsfsdf
//Example of how we should create rest services
@Path("/message")
@Component
@Service
public class MessageRestService {

//   @Resource
//    protected BundleContext context;

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

//        AccountService service = getService(AccountService.class);
		String result = "Restful example : " + msg;
		return Response.status(200).entity(result).build();
	}

}