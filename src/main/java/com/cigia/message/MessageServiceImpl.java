package com.cigia.message;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {


	private BidiMap<Message, String> store = new DualHashBidiMap<>();

	@Override
	public MessageDigest digestMessage(Message message) {
		String digest = store.get(message);

		if (digest == null) {
			digest = DigestUtils.sha256Hex(message.getMessage());
			store.put(message, digest);
		}
		return new MessageDigest(digest);
	}

	@Override
	public Message retrieveMessage(String messageDigest) {
		return store.inverseBidiMap().get(messageDigest);
	}
}
