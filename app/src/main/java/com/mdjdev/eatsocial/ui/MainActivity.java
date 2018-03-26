package com.mdjdev.eatsocial.ui;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.mdjdev.eatsocial.R;

import org.json.JSONException;


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
    LoginResult loginResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Intent intentGet = getIntent();
        String id = intentGet.getStringExtra("id");
        String imageUrl = intentGet.getStringExtra("imageUrl");
        String name = intentGet.getStringExtra("name");
        String surname = intentGet.getStringExtra("surname");
        Intent intentPush = new Intent(MainActivity.this, ListActivity.class);


        Typeface comfortaaFont = Typeface.createFromAsset(getAssets(), "fonts/Comfortaa_Regular.ttf");

        mHeadingText.setTypeface(comfortaaFont);
        mSubHeading.setTypeface(comfortaaFont);
        mMapButton.setOnClickListener(this);
        mListButton.setOnClickListener(this);





        //API call


        GraphRequest request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + id + "/friends",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted( GraphResponse graphResponse) {
                        String friends = graphResponse.getRawResponse();
                        try {
                            Log.v("Output", graphResponse.getJSONObject().getJSONArray("data").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        GraphRequest.executeBatchAsync(request);
    }

    @Override
    public void onClick(View v) {
        if(v == mListButton) {
            String zip = mZipCode.getText().toString();
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            Intent intentGet = getIntent();
            String id = intentGet.getStringExtra("id");
            intent.putExtra("zip", zip);
            intent.putExtra("id", id);
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