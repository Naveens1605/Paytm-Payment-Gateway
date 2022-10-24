package com.tiffytaste.paytmpaymentgateway.repository;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tiffytaste.paytmpaymentgateway.model.Enums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

@Repository
public class UserRepository {

    @Autowired
    FirebaseDatabase firebaseDatabase;

    private com.tiffytaste.paytmpaymentgateway.model.User user;

    CountDownLatch countDownLatch = new CountDownLatch(1);

    public UserDetails findUserById(String userId) {
        try {
            firebaseDatabase.getReference().child(Enums.USER.getValue()).child(userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    user = dataSnapshot.getValue(com.tiffytaste.paytmpaymentgateway.model.User.class);
                    countDownLatch.countDown();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            countDownLatch.await();
            return User.withUsername(user.getId()).password(user.getName()).authorities(new ArrayList<>()).build();
        } catch (Exception e) {
            throw new UsernameNotFoundException("User Not Found");
        }
    }

}

