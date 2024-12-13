// Firebase 메시지를 전송하는 서비스
package com.nongshim.infra.firebase;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class FCMService {

	public void sendMessage(String token, String title, String body) throws Exception {
		
//        Message message = Message.builder()
//            .setToken(token)
//            .setNotification(new Notification(title, body))
//            .build();
		
		Notification notification = Notification.builder()
				.setTitle(title)
				.setBody(body)
				.build();

		Message message = Message.builder()
				.setToken(token)
				.setNotification(notification)
				.build();

		String response = FirebaseMessaging.getInstance().send(message);
		System.out.println("Successfully sent message: " + response);
	}

}
