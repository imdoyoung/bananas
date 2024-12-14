// Firebase Admin SDK를 초기화하는 구성 클래스 >> 통신준비 완료
package com.nongshim.infra.firebase;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;

@Configuration
public class FirebaseConfig {

	@Bean
    public FirebaseApp initializeFirebase() throws IOException {
        
		// FirebaseApp이 이미 초기화되었는지 확인
		if (FirebaseApp.getApps().isEmpty()) {

//				FileInputStream serviceAccount = new FileInputStream("/bananas/src/main/resources/firebase/firebase-adminsdk.json");
				FileInputStream serviceAccount = new FileInputStream(new ClassPathResource("firebase/firebase-adminsdk.json").getFile());
				
				FirebaseOptions options = FirebaseOptions.builder()
						.setCredentials(GoogleCredentials.fromStream(serviceAccount))
						.setDatabaseUrl("https://superbad-bananas-firebase-chat-default-rtdb.firebaseio.com/")
						.build();
			
				return FirebaseApp.initializeApp(options);
		} else {
			// 이미 초기화된 경우 기존 FirebaseApp 반환
            return FirebaseApp.getInstance();
		}

    }
	
	@Bean
    public FirebaseDatabase firebaseDatabase() {
        return FirebaseDatabase.getInstance();
    }
	
}
