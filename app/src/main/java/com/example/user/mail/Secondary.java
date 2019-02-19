package com.example.user.mail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Secondary extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);


        EmailItem emailItem = getIntent().getParcelableExtra("email item");
        // Extract data

        String userImg = emailItem.getUserImg();
        String userName = emailItem.getTitle();
        String emailSubject = emailItem.getSecondtext();
        String emailCompose = emailItem.getText();
        String emailDate = emailItem.getDate();

        ImageView userImgIv = findViewById(R.id.user_image);
        TextView userNameTv = findViewById(R.id.title_text);
        TextView emailSubjectTv = findViewById(R.id.second_text);
        TextView emailComposeTv = findViewById(R.id.t1);
        TextView emailDateTv = findViewById(R.id.data_text);

        if (userImg != null && !userImg.isEmpty()) {
            Glide.with(this).load(userImg).into(userImgIv);
        } else {
            String userImgDefault = "https://www.qualiscare.com/wp-content/uploads/2017/08/default-user.png";
            Glide.with(this).load(userImgDefault).into(userImgIv);
        }

        if (userName != null && !userName.isEmpty()) {
            userNameTv.setText(userName);
        } else {
            userNameTv.setText(R.string.name);
        }

        if (emailSubject != null && !emailSubject.isEmpty()) {
            emailSubjectTv.setText(emailSubject);
        } else {
            emailSubjectTv.setText(R.string.topic);
        }

        if (emailCompose != null && !emailCompose.isEmpty()) {
            emailComposeTv.setText(emailCompose);
        } else {
            emailComposeTv.setText(R.string.email_text);
        }

        if (emailDate != null && !emailDate.isEmpty()) {
            emailDateTv.setText(emailDate);
        } else {
            emailDateTv.setText(R.string.email_date);
        }

    }

    }
