package com.product.demo.response;

public class StatusResponse {

	private String Message;
	private String Status;

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "StatusResponse [Message=" + Message + ", Status=" + Status + "]";
	}

}
