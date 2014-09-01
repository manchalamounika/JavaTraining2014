package com.vl.calendar.profile;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

@Path("/profile")
public class Profile_Resource 
{
	@Context
	Request req;
	ProfileDAO dao=new ProfileDAO();
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Collection<UserProfile> getall(@Context HttpServletRequest request)
	{
		return dao.getUserProfile((Integer)request.getSession().getAttribute("userid")).values();
	}
}
