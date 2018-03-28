package com.mdjdev.eatsocial.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.mdjdev.eatsocial.R;
import com.mdjdev.eatsocial.adapters.ListAdapter;
import com.mdjdev.eatsocial.models.CheckIn;
import com.mdjdev.eatsocial.models.Friends;
import com.mdjdev.eatsocial.models.User;
import com.mdjdev.eatsocial.service.FacebookService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Response;


public class ListActivity extends AppCompatActivity {
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private ListAdapter mAdapter;
    public static final String TAG = ListActivity.class.getSimpleName();
    public ArrayList<Friends> friends = new ArrayList<>();
    public ArrayList<CheckIn> checkIns = new ArrayList<>();
    User user = new User();
    public int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Log.d("id", id);
        Bundle bundle = getIntent().getExtras();

        getFriends(id);
    }

    private void getFriends(String id) {
        GraphRequest friendRequest = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + id + "/friends",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse graphResponse) {

                        try {
                            Log.v("Output", graphResponse.getJSONObject().getJSONArray("data").toString());
                            final JSONArray friendsJSON = graphResponse.getJSONObject().getJSONArray("data");
                            for (int i = 0; i < friendsJSON.length(); i++) {
                                JSONObject friendJSON = friendsJSON.getJSONObject(i);
                                String name = friendJSON.getString("name");
                                String id = friendJSON.getString("id");
                                Friends friend = new Friends(name, id, checkIns);
                                Log.d("Friend Call", friend.getName().toString());
                                friends.add(friend);
                                for (int j = 0; j < friends.size(); j++) {
                                    counter = j;
                                    GraphRequest checkinRequest = GraphRequest.newGraphPathRequest(
                                            AccessToken.getCurrentAccessToken(),
                                            "/" + id + "/tagged_places",
                                            new GraphRequest.Callback() {
                                                @Override
                                                public void onCompleted(GraphResponse graphResponse) {
                                                    try {
                                                        JSONArray checkinJSON = graphResponse.getJSONObject().getJSONArray("data");
                                                        for (int k = 0; k < checkinJSON.length(); k++) {
                                                            JSONObject friendJSON = checkinJSON.getJSONObject(k);
                                                            String placeName = friendJSON.getJSONObject("place").getString("name");
                                                            String placeId = friendJSON.getJSONObject("place").getString("id");
//                                                            String city = friendJSON.getJSONObject("place").getJSONObject("location").getString("city");
//                                                            String state = friendJSON.getJSONObject("place").getJSONObject("location").getString("state");
                                                            String placeLat = friendJSON.getJSONObject("place").getJSONObject("location").getString("latitude");
                                                            String placeLong = friendJSON.getJSONObject("place").getJSONObject("location").getString("longitude");
                                                            CheckIn checkIn = new CheckIn(placeName, placeId, placeLat, placeLong);
                                                            checkIns.add(checkIn);
                                                            Log.d("API call", checkIns.toString());

                                                        }
                                                        friends.get(counter).setCheckIn(checkIns);
                                                        Log.d("FRIENDCHECKIN", checkIns.toString());
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
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            });

                                    GraphRequest.executeBatchAsync(checkinRequest);

                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

        GraphRequest.executeBatchAsync(friendRequest);

    }
}