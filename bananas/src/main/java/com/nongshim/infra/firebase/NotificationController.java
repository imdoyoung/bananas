package com.nongshim.infra.firebase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private FCMService fcmService;

    // POST 요청 처리
    @PostMapping("/send")
    public String sendNotificationPost(@RequestParam String token, @RequestParam String title, @RequestParam String body) {
        return sendNotification(token, title, body);
    }

    // GET 요청 처리
    @GetMapping("/send")
    public String sendNotificationGet(@RequestParam String token, @RequestParam String title, @RequestParam String body) {
        return sendNotification(token, title, body);
    }

    // 공통 로직
    private String sendNotification(String token, String title, String body) {
        try {
            fcmService.sendMessage(token, title, body);
            return "Notification sent successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send notification";
        }
    }
}
