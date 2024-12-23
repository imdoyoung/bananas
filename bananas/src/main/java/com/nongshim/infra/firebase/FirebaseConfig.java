//// Firebase Admin SDK를 초기화하는 구성 클래스 >> 통신준비 완료

package com.nongshim.infra.firebase;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

@Configuration
public class FirebaseConfig {

    // Firebase 초기화
    @Bean
    public FirebaseApp initializeFirebase() throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {
            // ClassPathResource를 통해 InputStream으로 리소스 로드
            InputStream serviceAccount = new ClassPathResource("firebase/firebase-adminsdk.json").getInputStream();

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://superbad-bananas-firebase-chat-default-rtdb.firebaseio.com/")
                    .build();

            return FirebaseApp.initializeApp(options);
        } else {
            return FirebaseApp.getInstance(); // 이미 초기화된 FirebaseApp 반환
        }
    }

    // FirebaseDatabase 인스턴스를 제공하는 Bean
    @Bean
    public FirebaseDatabase firebaseDatabase(FirebaseApp firebaseApp) {
        return FirebaseDatabase.getInstance(firebaseApp); // FirebaseApp을 명시적으로 전달
    }
}







//package com.nongshim.infra.firebase;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.database.FirebaseDatabase;
//
//@Configuration
//public class FirebaseConfig {
//
//    // Firebase 초기화
//    @Bean
//    public FirebaseApp initializeFirebase() throws IOException {
//        if (FirebaseApp.getApps().isEmpty()) {
//            FileInputStream serviceAccount = new FileInputStream(new ClassPathResource("firebase/firebase-adminsdk.json").getFile());
//            FirebaseOptions options = FirebaseOptions.builder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setDatabaseUrl("https://superbad-bananas-firebase-chat-default-rtdb.firebaseio.com/")
//                    .build();
//
//            return FirebaseApp.initializeApp(options);
//        } else {
//            return FirebaseApp.getInstance(); // 이미 초기화된 FirebaseApp 반환
//        }
//    }
//
//    // FirebaseDatabase 인스턴스를 제공하는 Bean
//    @Bean
//    public FirebaseDatabase firebaseDatabase() throws IOException {
//        FirebaseApp firebaseApp = initializeFirebase(); // FirebaseApp 초기화
//        return FirebaseDatabase.getInstance(firebaseApp); // FirebaseApp을 명시적으로 전달
//    }
//}







//package com.nongshim.infra.firebase;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.database.FirebaseDatabase;
//
//@Configuration
//public class FirebaseConfig {
//
//   @Bean
//    public FirebaseApp initializeFirebase() throws IOException {
//        
//      // FirebaseApp이 이미 초기화되었는지 확인
//      if (FirebaseApp.getApps().isEmpty()) {
//
////            FileInputStream serviceAccount = new FileInputStream("/bananas/src/main/resources/firebase/firebase-adminsdk.json");
//            FileInputStream serviceAccount = new FileInputStream(new ClassPathResource("firebase/firebase-adminsdk.json").getFile());
//            
//            FirebaseOptions options = FirebaseOptions.builder()
//                  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                  .setDatabaseUrl("https://superbad-bananas-firebase-chat-default-rtdb.firebaseio.com/")
//                  .build();
//         
//            return FirebaseApp.initializeApp(options);
//      } else {
//         // 이미 초기화된 경우 기존 FirebaseApp 반환
//            return FirebaseApp.getInstance();
//      }
//
//    }
//   
//   @Bean
//    public FirebaseDatabase firebaseDatabase() {
//        return FirebaseDatabase.getInstance();
//    }
//   
//}
