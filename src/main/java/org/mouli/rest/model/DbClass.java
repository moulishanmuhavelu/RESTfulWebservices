package org.mouli.rest.model;

import java.util.HashMap;
import java.util.Map;

public class DbClass {

	private static Map<Integer, Message> msgMap = new HashMap<Integer, Message>();
	
	public static Map<Integer, Message> getMessages() {
		return msgMap;
	}
}
