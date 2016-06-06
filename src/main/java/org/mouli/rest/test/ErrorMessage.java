package org.mouli.rest.test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private int errorCode;
	private String errorMessage;
	public int getErrorCode() {
		return errorCode;
	}
	public ErrorMessage() {
		
	}
	public ErrorMessage(int errorCode, String errorMessage ) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;		
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
