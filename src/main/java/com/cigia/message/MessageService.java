package com.cigia.message;

interface MessageService {

	MessageDigest digestMessage(Message message);

	Message retrieveMessage(String messageDigest);
}
