package com.cigia.message;

public class MessageDigest {
	private String digest;

	MessageDigest() {}

	MessageDigest(String digest){
		this.digest = digest;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}
}


