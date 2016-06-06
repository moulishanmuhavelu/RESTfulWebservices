package org.mouli.rest.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.mouli.rest.model.DbClass;
import org.mouli.rest.model.Message;
import org.mouli.rest.service.MessageService;

@Path("/messageResponse")
public class MessageResponse {

	MessageService msgService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> messages() {
		Map<Integer, Message> map = DbClass.getMessages();

		return msgService.getAllMessages();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addMessage(Message message) {
		return Response.status(Status.CREATED).entity(message).build();
//		return message;
	}
}
