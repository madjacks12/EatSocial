package com.mdjdev.eatsocial.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mdjdev.eatsocial.R;
import com.mdjdev.eatsocial.models.CheckIn;
import com.mdjdev.eatsocial.models.Friends;
import com.mdjdev.eatsocial.ui.FriendDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static java.lang.String.valueOf;

/**
 * Created by Matthew on 3/30/2018.
 */

public class CheckInAdapter extends RecyclerView.Adapter<CheckInAdapter.CheckInViewHolder> {
    private ArrayList<CheckIn> mCheckIns = new ArrayList<>();
    private Context mContext;

    public CheckInAdapter(Context context, ArrayList<CheckIn> mCheckIns) {
        mContext = context;
        mCheckIns = mCheckIns;
    }

    @Override
    public CheckInAdapter.CheckInViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkin_list_item, parent, false);
        CheckInAdapter.CheckInViewHolder viewHolder = new CheckInAdapter.CheckInViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CheckInAdapter.CheckInViewHolder holder, int position) {
        holder.bindCheckIns(mCheckIns.get(position));
    }


    @Override
    public int getItemCount() {
        return mCheckIns.size();
    }


    public class CheckInViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.checkInNameTextView) TextView mCheckInNameTextView;
        private Context mContext;

        public CheckInViewHolder(View itemView) {
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
            intent.putExtra("checkIn", Parcels.wrap(mCheckIns));
            mContext.startActivity(intent);
        }

        public void bindCheckIns(CheckIn checkIn) {
            mCheckInNameTextView.setText(checkIn.getPlaceName());



        }
    }
}
