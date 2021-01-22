package com.database.system.wsconsumedatabase.error;

import java.time.LocalDate;

public class ErrorResponse {
	
	private  String status;
	private  String message ;
	private  Integer code;
	private LocalDate timeStamp;
	
 
	public ErrorResponse(String status, String message, Integer code, LocalDate timestamp) {
		this.status = status;
		this.message = message;
		this.code = code;
		this.timeStamp = timestamp;
	}


	public String getStatus() {
		return status;
	}


	public String getMessage() {
		return message;
	}


	public Integer getCode() {
		return code;
	}


	public LocalDate getTimeStamp() {
		return timeStamp;
	}
	
	
}
