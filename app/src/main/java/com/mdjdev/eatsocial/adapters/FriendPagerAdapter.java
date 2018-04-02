package com.mdjdev.eatsocial.adapters;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mdjdev.eatsocial.models.Friends;
import com.mdjdev.eatsocial.ui.FriendDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 3/28/18.
 */

public class FriendPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Friends> mFriends;

    public FriendPagerAdapter(FragmentManager fm, ArrayList<Friends> friends) {
        super(fm);
        mFriends = friends;
    }

    @Override
    public Fragment getItem(int position) {
        return FriendDetailFragment.newInstance(mFriends.get(position));
    }

    @Override
    public int getCount() {

        return mFriends.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mFriends.get(position).getName();
    }
}
