package com.mdjdev.eatsocial.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mdjdev.eatsocial.R;
import com.mdjdev.eatsocial.models.Friends;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FriendDetailFragment extends Fragment {
    @Bind(R.id.friendNameTextView)
    TextView mNameLabel;
    @Bind(R.id.mapButtonView) Button mCategoriesLabel;

    private Friends mFriends;

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
        mFriends = Parcels.unwrap(getArguments().getParcelable("friends"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_detail, container, false);
        ButterKnife.bind(this, view);

        mNameLabel.setText(mFriends.getName());

        return view;
    }
}