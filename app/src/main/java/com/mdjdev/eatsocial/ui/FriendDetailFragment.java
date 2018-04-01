package com.mdjdev.eatsocial.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mdjdev.eatsocial.R;
import com.mdjdev.eatsocial.adapters.ListAdapter;
import com.mdjdev.eatsocial.models.CheckIn;
import com.mdjdev.eatsocial.models.Friends;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.facebook.FacebookSdk.getApplicationContext;


public class FriendDetailFragment extends Fragment{
    @Bind(R.id.friendNameTextView) TextView mNameLabel;
    @Bind(R.id.listView) ListView mListView;
    private Friends mFriend;
    ArrayList<String>names = new ArrayList<String>();

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
        ArrayList<CheckIn> checkins = mFriend.getCheckIn();

            for (int i = 0; i < checkins.size(); i++) {
                String name = checkins.get(i).getPlaceName();
                names.add(name);
            }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, names);
        mListView.setAdapter(adapter);


        return view;
    }
}