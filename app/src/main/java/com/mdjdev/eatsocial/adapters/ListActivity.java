package com.mdjdev.eatsocial.adapters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.mdjdev.eatsocial.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {

    @Bind(R.id.restaurantHeader) TextView mRestaurantHeader;
    @Bind(R.id.listView) ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String zip = intent.getStringExtra("zip");
        mRestaurantHeader.setText("Your Friends ate here in: " + zip);

        ListAdapter adapter = new ListAdapter(this, android.R.layout.simple_list_item_1, restaurants, friends);
        mListView.setAdapter(adapter);
    }
}
