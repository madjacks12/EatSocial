package com.mdjdev.eatsocial.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mdjdev.eatsocial.R;
import com.mdjdev.eatsocial.models.Friends;
import com.mdjdev.eatsocial.ui.FriendDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Matthew on 3/16/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.FriendViewHolder> {
    private ArrayList<Friends> mFriends = new ArrayList<>();
    private Context mContext;

    public ListAdapter(Context context, ArrayList<Friends> restaurants) {
        mContext = context;
        mFriends = restaurants;
    }

    @Override
    public ListAdapter.FriendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_list_item, parent, false);
        FriendViewHolder viewHolder = new FriendViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListAdapter.FriendViewHolder holder, int position) {
        holder.bindFriends(mFriends.get(position));
    }

    @Override
    public int getItemCount() {
        return mFriends.size();
    }


    public class FriendViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.friendNameTextView) TextView mNameTextView;
        private Context mContext;

        public FriendViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, FriendDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("friends", Parcels.wrap(mFriends));
            mContext.startActivity(intent);
        }

        public void bindFriends(Friends friend) {
            mNameTextView.setText(friend.getName());
        }
    }
}
