package org.mouli.rest.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.mouli.rest.model.DbClass;
import org.mouli.rest.model.Message;

public class MessageService {

	public MessageService() {
		Message m1 = new Message(Integer.valueOf(1),"Hello RESTLearner", "Mouli");
		Message m2 = new Message(Integer.valueOf(2),"Hello Baby", "Haran");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2013);
		m1.setCreated(cal.getTime());
		
		
		DbClass.getMessages().put(Integer.valueOf(m1.getId()), m1);
		DbClass.getMessages().put(Integer.valueOf(m2.getId()), m2);
	}
	public List<Message> getAllMessages() {
		return new ArrayList<Message> (DbClass.getMessages().values());		
	}
	public Message getMessage(int msgId) {
		return DbClass.getMessages().get(Integer.valueOf(msgId));
	}
	public Message addMessage(Message message) {
		int msgId = DbClass.getMessages().size() + 1;
		message.setId(msgId);
		DbClass.getMessages().put(Integer.valueOf(msgId), message);
		return message;
	}
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		DbClass.getMessages().put(Integer.valueOf(message.getId()), message);
		return message;
	}
	public Message removeMessage(int id) {
		return DbClass.getMessages().remove(Integer.valueOf(id));
	}
}
