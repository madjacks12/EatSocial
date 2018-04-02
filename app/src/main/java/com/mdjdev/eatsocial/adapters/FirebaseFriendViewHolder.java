package com.mdjdev.eatsocial.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mdjdev.eatsocial.Constants;
import com.mdjdev.eatsocial.R;
import com.mdjdev.eatsocial.models.Friends;
import com.mdjdev.eatsocial.ui.FriendDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import static java.lang.String.valueOf;

/**
 * Created by Matthew on 4/1/2018.
 */

public class FirebaseFriendViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseFriendViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindRestaurant(Friends friend) {
        TextView nameTextView = mView.findViewById(R.id.friendNameTextView);
        TextView checkInTextView = mView.findViewById(R.id.checkinTextView);

        nameTextView.setText(friend.getName());
        checkInTextView.setText( valueOf(friend.getCheckIn().size()) + " check-in's");

    }


    @Override
    public void onClick(View view) {

        final ArrayList<Friends> friends = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_FRIENDS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    friends.add(snapshot.getValue(Friends.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, FriendDetailActivity.class);
                intent.putExtra("position", itemPosition);
                intent.putExtra("friends", Parcels.wrap(friends));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
