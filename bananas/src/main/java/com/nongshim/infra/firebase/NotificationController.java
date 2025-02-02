package com.nongshim.infra.firebase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@RestController
public class NotificationController {

   @Autowired
   private FCMService fcmService;

   @Autowired
   private FirebaseDatabase firebaseDatabase;

   private static final String MESSAGES_NODE = "messages";

   // 메시지 전송 (Firebase 저장)
   @PostMapping("/send")
   public String sendMessage(MessageDto messageDto) {
      DatabaseReference ref = firebaseDatabase.getReference(MESSAGES_NODE);
      messageDto.setTimestamp(System.currentTimeMillis());
      ref.push().setValueAsync(messageDto);
      return "Message sent";
   }

   // 최신 메시지 조회 (AJAX용)
//   @GetMapping
//   public CompletableFuture<List<MessageDto>> getMessages() {
//       final List<MessageDto> messages = new ArrayList<>();
//       DatabaseReference ref = firebaseDatabase.getReference(MESSAGES_NODE);
//       
//       // CompletableFuture를 사용하여 비동기적으로 처리
//       CompletableFuture<List<MessageDto>> future = new CompletableFuture<>();
//       
//       ref.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
//           @Override
//           public void onSuccess(DataSnapshot snapshot) {
//               for (DataSnapshot messageSnapshot : snapshot.getChildren()) {
//                   MessageDto messageDto = messageSnapshot.getValue(MessageDto.class); // Message -> MessageDto
//                   if (messageDto != null) {
//                       messages.add(messageDto);
//                   }
//               }
//               // 데이터를 다 받은 후 CompletableFuture를 완료시킴
//               future.complete(messages);
//           }
//       }).addOnFailureListener(new OnFailureListener() {
//           @Override
//           public void onFailure(Exception e) {
//               // 실패 시 CompletableFuture를 예외로 완료시킴
//               future.completeExceptionally(e);
//           }
//       });
//       
//       return future;
//   }
   
   @GetMapping("/read")
   public CompletableFuture<List<MessageDto>> getMessages() {
       // CompletableFuture 생성
       CompletableFuture<List<MessageDto>> future = new CompletableFuture<>();
       
       // Firebase Realtime Database에서 메시지 가져오기
       DatabaseReference ref = firebaseDatabase.getReference(MESSAGES_NODE);
       
       // Firebase에서 데이터를 비동기적으로 받아옴
       ref.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot snapshot) {
               List<MessageDto> messages = new ArrayList<>();
               // 데이터가 있으면 MessageDto로 변환하여 리스트에 추가
               for (DataSnapshot messageSnapshot : snapshot.getChildren()) {
                   MessageDto messageDto = messageSnapshot.getValue(MessageDto.class);
                   if (messageDto != null) {
                       messages.add(messageDto);
                   }
               }
               // 데이터를 받은 후 CompletableFuture 완료
               future.complete(messages);
               System.out.println(messages.get(0).getMessage() + "@@@@@@@@@@@@@@@@@@@@@@@@@");
           }

           @Override
           public void onCancelled(DatabaseError error) {
               // 실패 시 CompletableFuture에 예외 처리
               future.completeExceptionally(error.toException());
           }
       });

       return future;
   }




   
   
   // 앱 푸쉬용
//    // POST 요청 처리
//    @PostMapping("/send")
//    public String sendNotificationPost(@RequestParam String token, @RequestParam String title, @RequestParam String body) {
//        return sendNotification(token, title, body);
//    }
//
//    // GET 요청 처리
//    @GetMapping("/send")
//    public String sendNotificationGet(@RequestParam String token, @RequestParam String title, @RequestParam String body) {
//        return sendNotification(token, title, body);
//    }
//
//    // 공통 로직
//    private String sendNotification(String token, String title, String body) {
//        try {
//            fcmService.sendMessage(token, title, body);
//            return "Notification sent successfully";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Failed to send notification";
//        }
//    }
}