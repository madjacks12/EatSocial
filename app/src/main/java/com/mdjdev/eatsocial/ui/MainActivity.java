package com.mdjdev.eatsocial.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.headingText) TextView mHeadingText;
    @BindView(R.id.subHeading) TextView mSubHeading;
    @BindView(R.id.listButton) Button mListButton;
    @BindView(R.id.mapButton) Button mMapButton;
    @BindView(R.id.imageView) ImageView mImageView;
    @BindView(R.id.zipCode) EditText mZipCode;
    Intent intent;
    LoginResult loginResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String imageUrl = intent.getStringExtra("imageUrl");
        String name = intent.getStringExtra("name");
        String surname = intent.getStringExtra("surname");
        mHeadingText = (TextView) findViewById(R.id.headingText);
        mSubHeading = (TextView) findViewById(R.id.subHeading);
        mZipCode = (EditText) findViewById(R.id.zipCode);
        Typeface comfortaaFont = Typeface.createFromAsset(getAssets(), "fonts/Comfortaa_Regular.ttf");

        mHeadingText.setTypeface(comfortaaFont);
        mSubHeading.setTypeface(comfortaaFont);

        ButterKnife.bind(this);
        mListButton.setOnClickListener(this);
        mMapButton.setOnClickListener(this);

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