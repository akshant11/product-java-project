package com.product.demo.response;

public class ProductStatusResponse {

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
		return "ProductStatusResponse [Message=" + Message + ", Status=" + Status + "]";
	}

}
