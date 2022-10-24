package com.tiffytaste.paytmpaymentgateway.di;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseModule {

    @Value(value = "classpath:tiffytaste-8bd21-firebase-adminsdk-mnb58-d2a679f912.json")
    private Resource serviceAccountResource;

    @Bean
    public FirebaseApp createFireBaseApp() throws IOException {
        InputStream serviceAccount = serviceAccountResource.getInputStream();

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://tiffytaste-8bd21-default-rtdb.firebaseio.com/")
                .build();

        return FirebaseApp.initializeApp(options);
    }


    @Bean
    @DependsOn(value = "createFireBaseApp")
    public FirebaseAuth createFirebaseAuth() {
        return FirebaseAuth.getInstance();
    }

    @Bean
    @DependsOn(value = "createFireBaseApp")
    public FirebaseDatabase createFirebaseDatabase() {
        return FirebaseDatabase.getInstance();
    }

}
