package com.postmaninteractive.postman.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.postmaninteractive.postman.Models.EventEntry;
import com.postmaninteractive.postman.R;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {
    private static final String TAG = "EventsAdapter";
    private List<EventEntry> events;


    public EventsAdapter(List<EventEntry> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_event_entry, viewGroup, false);

        return new EventsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder eventsViewHolder, int i) {

        eventsViewHolder.title.setText(events.get(i).getTitle());
        eventsViewHolder.message.setText(events.get(i).getMessage());
    }

    @Override
    public int getItemCount() {
        if(events == null){
            return 0;
        }
        return events.size();
    }


    public class EventsViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView message;

        public EventsViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            message = (TextView) view.findViewById(R.id.message);
        }
    }
}
