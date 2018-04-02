package com.mdjdev.eatsocial.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mdjdev.eatsocial.Constants;
import com.mdjdev.eatsocial.R;
import com.mdjdev.eatsocial.adapters.CheckInAdapter;
import com.mdjdev.eatsocial.adapters.ListAdapter;
import com.mdjdev.eatsocial.models.CheckIn;
import com.mdjdev.eatsocial.models.Friends;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.facebook.FacebookSdk.getApplicationContext;


public class FriendDetailFragment extends Fragment implements View.OnClickListener{
    @Bind(R.id.friendNameTextView) TextView mNameLabel;
    @Bind(R.id.listView) ListView mListView;
    @Bind(R.id.saveFriendButton) Button mSaveFriendButton;
    private Friends mFriend;
    ArrayList<String>names = new ArrayList<>();
    ArrayList<String>latitude = new ArrayList<>();
    ArrayList<String>longitude = new ArrayList<>();

    public static FriendDetailFragment newInstance(Friends friend) {
        FriendDetailFragment friendDetailFragment = new FriendDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("friend", Parcels.wrap(friend));
        friendDetailFragment.setArguments(args);
        return friendDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFriend = Parcels.unwrap(getArguments().getParcelable("friend"));



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_detail, container, false);
        ButterKnife.bind(this, view);
        mNameLabel.setText(mFriend.getName());
        List<CheckIn> checkins = mFriend.getCheckIn();

            for (int i = 0; i < checkins.size(); i++) {
                String name = checkins.get(i).getPlaceName();
                String lat = checkins.get(i).getPlaceLat();
                String longit = checkins.get(i).getPlaceLong();
                names.add(name);
                latitude.add(lat);
                longitude.add(longit);
            }

        mSaveFriendButton.setOnClickListener(this);


        final CheckInAdapter adapter = new CheckInAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, names, latitude, longitude);
        mListView.setAdapter(adapter);
        mListView.setClickable(true);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:" + latitude.get(position)
                                + "," + longitude.get(position)
                                + "?q=(" + names.get(position) + ")"));
                Log.d("latitude", latitude.get(position));
                Log.d("name", names.get(position));
                startActivity(mapIntent);
            }
        });


        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSaveFriendButton) {
            DatabaseReference friendsRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_FRIENDS);
            friendsRef.push().setValue(mFriend);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}