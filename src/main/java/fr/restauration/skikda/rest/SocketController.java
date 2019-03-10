package fr.restauration.skikda.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {

	private SimpMessagingTemplate messagingTemplate;
	
	@Autowired
	public SocketController(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
	
	@MessageMapping("/user/queue/updates/{idUser}")
	public void onRecivedMessage(String message,@DestinationVariable Integer idUser) {
		
		System.out.println("idUser "+idUser);
		
		messagingTemplate.convertAndSend("/user/queue/specific-user/"+idUser,message);
	}
	
	
	
}
