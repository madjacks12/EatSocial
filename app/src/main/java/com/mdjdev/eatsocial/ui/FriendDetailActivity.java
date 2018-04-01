package com.mdjdev.eatsocial.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mdjdev.eatsocial.R;
import com.mdjdev.eatsocial.adapters.FriendPagerAdapter;
import com.mdjdev.eatsocial.adapters.ListAdapter;
import com.mdjdev.eatsocial.models.Friends;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FriendDetailActivity extends AppCompatActivity {

        @Bind(R.id.viewPager)
        ViewPager mViewPager;
        private FriendPagerAdapter adapterViewPager;
        ArrayList<Friends> mFriends = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_friend_detail);
            ButterKnife.bind(this);

            mFriends = Parcels.unwrap(getIntent().getParcelableExtra("friends"));

            int startingPosition = getIntent().getIntExtra("position", 0);

            adapterViewPager = new FriendPagerAdapter(getSupportFragmentManager(), mFriends);
            mViewPager.setAdapter(adapterViewPager);
            mViewPager.setCurrentItem(startingPosition);
        }
    }