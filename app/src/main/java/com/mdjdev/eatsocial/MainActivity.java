package com.mdjdev.eatsocial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.headingText) TextView mHeadingText;
    @Bind(R.id.subHeading) TextView mSubHeading;
    @Bind(R.id.listButton) Button mListButton;
    @Bind(R.id.mapButton) Button mMapButton;
    @Bind(R.id.imageView) ImageView mImageView;
    @Bind(R.id.zipCode) EditText mZipCode;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeadingText = (TextView) findViewById(R.id.headingText);
        mSubHeading = (TextView) findViewById(R.id.subHeading);
        mZipCode = (EditText) findViewById(R.id.zipCode);
        Typeface comfortaaFont = Typeface.createFromAsset(getAssets(), "fonts/Comfortaa_Regular.ttf");

        mHeadingText.setTypeface(comfortaaFont);
        mSubHeading.setTypeface(comfortaaFont);

        ButterKnife.bind(this);
        mListButton.setOnClickListener(this);
        mMapButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if(v == mListButton) {
            String zip = mZipCode.getText().toString();
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            intent.putExtra("zip", zip);
            if (zip.length() != 5) {
                Toast.makeText(MainActivity.this, "Zip Code must be 5 digits", Toast.LENGTH_SHORT).show();
            }
            else {
                startActivity(intent);
            }
        }
        if(v == mMapButton) {
            String zip = mZipCode.getText().toString();
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            intent.putExtra("zip", zip);
            if (zip.length() != 5) {
                Toast.makeText(MainActivity.this, "Zip Code must be 5 digits", Toast.LENGTH_SHORT).show();
            }
            else {
                startActivity(intent);
            }
        }
    }

    }

