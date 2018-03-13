package com.example.admin.gmchallenge.data.view.eventlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.gmchallenge.R;
import com.example.admin.gmchallenge.data.model.Meetup;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Luis on 3/13/18.
 */

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder>{

    private final OnItemClickListener listener;
    private List<Meetup> meetupList;
    private Context context;

    public EventListAdapter(Context context, List<Meetup> meetupList, OnItemClickListener listener) {
        this.meetupList = meetupList;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public EventListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(EventListAdapter.ViewHolder holder, int position) {
        holder.click(meetupList.get(position), listener);
        Meetup meetup = meetupList.get(position);
        holder.tvEvent.setText(meetup.getName());
        holder.tvDesc.setText(meetup.getCountry());

        try {
            String images = meetup.getKeyPhoto().getHighresLink();
            Picasso.with(context)
                    .load(images)
                    .into(holder.ivEvent);
        }catch (Exception e){

        }
    }


    @Override
    public int getItemCount() {
        return meetupList.size();
    }


    public interface OnItemClickListener {
        void onClick(Meetup Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvEvent, tvDesc;
        ImageView ivEvent;

        public ViewHolder(View itemView) {
            super(itemView);
            tvEvent = itemView.findViewById(R.id.event);
            tvDesc = itemView.findViewById(R.id.description);
            ivEvent = itemView.findViewById(R.id.image);

        }


        public void click(final Meetup meetup, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(meetup);
                }
            });
        }
    }
}
