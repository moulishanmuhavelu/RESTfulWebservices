package org.mouli.rest.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.mouli.rest.model.DbClass;
import org.mouli.rest.model.Message;
import org.mouli.rest.service.MessageService;

@Path("/messageResource")
public class MessageResource {

	MessageService msgService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> messages(@QueryParam("year") int year) {
		Map<Integer, Message> map = DbClass.getMessages();
		List<Message> messages = msgService.getAllMessages();
		if (year > 0) {
			List<Message> filteredMessages = new ArrayList<Message>();
			for (Message message : messages) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(message.getCreated());
				if (cal.get(Calendar.YEAR) == year) {
					filteredMessages.add(message);
				}
			}
			return filteredMessages;
		} 
		return messages;
	}

	@GET
	@Path("/{msgId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("msgId") int messageId) {
		if (msgService.getMessage(messageId) == null) {
			throw new RuntimeException("Message with the id "+messageId+" not found");
		}
		return msgService.getMessage(messageId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message addMessage(Message message) {
		Message msg = msgService.addMessage(message);
		Map<Integer, Message> map = DbClass.getMessages();
		return msg;
	}
	
	@PUT
	@Path("/{msgId}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)	
	public Message updateMessage(@PathParam("msgId") int messageId, Message message) {
		message.setId(messageId);
		Message msg = msgService.updateMessage(message);
		Map<Integer, Message> map = DbClass.getMessages();
		return msg;
	}

	@DELETE
	@Path("/{msgId}")
	@Produces(MediaType.APPLICATION_XML)	
	public Message deleteMessage(@PathParam("msgId") int messageId) {
		Message msg = msgService.removeMessage(messageId);
		Map<Integer, Message> map = DbClass.getMessages();
		return msg;
	}
	

}
