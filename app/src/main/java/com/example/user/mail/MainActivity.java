package com.example.user.mail;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity implements EmailAdapter.EmailItemClicked {
    private static final String EMAIL_ITEM = "email item";
    private List<EmailItem> list = generateEmailList();


    private ImageView image_user, image_user2, image_detal_center;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView emailRecycler = findViewById(R.id.email_recycler_view);

        image_user = findViewById(R.id.user_image);
        image_user2 = findViewById(R.id.user_detal_view);

        Glide.with(this).load("https://pngimage.net/wp-content/uploads/2018/06/gambar-user-png-2.png").into(image_user);
        Glide.with(this).load("https://pngimage.net/wp-content/uploads/2018/06/gambar-user-png-2.png").into(image_user2);
        Glide.with(this).load("http://www.pngmart.com/files/2/Yoshi-PNG-File.png").into(image_detal_center);

        emailRecycler.setLayoutManager(new LinearLayoutManager(this));
        EmailAdapter emailAdapter = new EmailAdapter(list, this);
        emailRecycler.setAdapter(emailAdapter);

        android.support.design.widget.FloatingActionButton FloatActionButton = findViewById(R.id.fab);
        FloatActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateEmailactivity.class);
                startActivity(intent);

            }
        });

    }


    // переопределённый метод callback. Вызывается при кликах на элементы.
    // Больше информации можно найти в классе адаптера

    @Override
    public void itemClickedCallback(int itemPosition) {
        Intent intent = new Intent(this, Secondary.class);
        intent.putExtra(EMAIL_ITEM, list.get(itemPosition));
        startActivity(intent);
    }

    private List<EmailItem> generateEmailList() {
        List<EmailItem> list = new ArrayList<>();
        list.add(new EmailItem("Google", "Work", "Google invite you on work","14.02.19","https://itc.ua/wp-content/uploads/2017/10/google-logo-1200x630-1.jpg"));
        list.add(new EmailItem("", "Real-Time Dashboards ", "etuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis", "20m","\"https://pngimage.net/wp-content/uploads/2018/06/gambar-user-png-2.png\""));
        list.add(new EmailItem("Lucas 9-9", "Why is Python so popular despite being so slow? ", "ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis", "55m","\"https://pngimage.net/wp-content/uploads/2018/06/gambar-user-png-2.png\""));
        list.add(new EmailItem("Amazon Rose", "Will Canada buy the F-35? ", "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "1h","\"https://pngimage.net/wp-content/uploads/2018/06/gambar-user-png-2.png\""));
        list.add(new EmailItem("Maik", null, "Lorem impus... WHAT???!!!", "4h","\"https://pngimage.net/wp-content/uploads/2018/06/gambar-user-png-2.png\""));
        return list;
    }
}
