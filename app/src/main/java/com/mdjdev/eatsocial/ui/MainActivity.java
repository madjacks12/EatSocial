package com.mdjdev.eatsocial.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdjdev.eatsocial.DownloadImage;
import com.mdjdev.eatsocial.R;

public class MainActivity extends AppCompatActivity {
//    Bundle inBundle = getIntent().getExtras();
//    String name = inBundle.get("name").toString();
//    String surname = inBundle.get("surname").toString();
Intent intent = getIntent();
    String imageUrl = intent.getStringExtra("imageUrl");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView nameView = (TextView) findViewById(R.id.nameAndSurname);
        nameView.setText("" + "Dave" + " " + "Cheese");
        new DownloadImage((ImageView)findViewById(R.id.profileImage)).execute(imageUrl);
    }



}
