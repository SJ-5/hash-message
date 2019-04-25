package com.cigia.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/messages")
public class MessageController {

	private final MessageService messageService;

	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@PostMapping
	public MessageDigest hashMessage(@RequestBody Message message) {
		return messageService.digestMessage(message);
	}

	@GetMapping("/{hash}")
	public Message retriveMessages(@PathVariable String hash) {
		Message message = messageService.retrieveMessage(hash);
		if (message == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return message;
	}
}


