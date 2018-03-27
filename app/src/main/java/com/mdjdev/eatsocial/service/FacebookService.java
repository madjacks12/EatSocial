package com.mdjdev.eatsocial.service;

import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.mdjdev.eatsocial.models.Friends;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

import okhttp3.Callback;
import okhttp3.Response;

public class FacebookService{
    public static void getFriends(String id) {
        GraphRequest request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + id + "/friends",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse graphResponse) {
                        ArrayList<Friends> friends = new ArrayList<>();
                        try {
                            Log.v("Output", graphResponse.getJSONObject().getJSONArray("data").toString());
                            JSONArray friendsJSON = graphResponse.getJSONObject().getJSONArray("data");
                            for (int i = 0; i < friendsJSON.length(); i++) {
                                JSONObject friendJSON = friendsJSON.getJSONObject(i);
                                String name = friendJSON.getString("name");
                                String id = friendJSON.getString("id");
                                Friends friend = new Friends(name, id);
                                Log.d("Friend Call", friend.getName().toString());
                                friends.add(friend);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        GraphRequest.executeBatchAsync(request);
    }
}
