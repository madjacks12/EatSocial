package com.mdjdev.eatsocial.FacebookService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONException;

public class FacebookService{

public static void getFriends(String id) {
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
}
