package com.cigia.message;

public class Message {
	private String message;

	Message(){}

	Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Message)
			return message.equals(((Message) obj).getMessage());
		return false;
	}

	@Override
	public int hashCode() {
		return message.hashCode();
	}
}
