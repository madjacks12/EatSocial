package com.mdjdev.eatsocial.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mdjdev.eatsocial.FacebookService.FacebookService;
import com.mdjdev.eatsocial.R;
import com.mdjdev.eatsocial.adapters.ListAdapter;
import com.mdjdev.eatsocial.models.Friends;

import okhttp3.Call;
import okhttp3.Callback;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Response;




public class ListActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private ListAdapter mAdapter;
    public static final String TAG = ListActivity.class.getSimpleName();
    public ArrayList<Friends> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        getFriends(id);
    }

    private void getFriends(String id) {
        final FacebookService facebookService = new FacebookService();
        facebookService.getFriends(id);

        ListActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter = new ListAdapter(getApplicationContext(), friends);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager =
                        new LinearLayoutManager(ListActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);
            }
        });
    }
}