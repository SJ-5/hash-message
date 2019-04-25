package com.cigia.message;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MessageControllerTest {

	@Mock
	private MessageService messageService;

	MessageController messageController = new MessageController(messageService);

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		messageController = new MessageController(messageService);
	}

	@Test
	public void hashMessage() {
		Message message = new Message("foo");
		when(messageService.digestMessage(message)).thenReturn(new MessageDigest("abcd"));

		assertEquals(messageController.hashMessage(message).getDigest(), "abcd");
	}

	@Test
	public void retriveMessages() {
		Message message = new Message("foo");
		when(messageService.retrieveMessage("abcd")).thenReturn(message);

		assertEquals(messageController.retriveMessages("abcd"), message);


	}
}