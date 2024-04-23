package edu.andrews.edu.cptr252.alexandern.finalproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.EventViewHolder>{

    private List<EventData> eventList;
    NameAdapter(List<EventData> list) {eventList = list;}

    public void setEventList(List<EventData> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_cell, parent, false);
        return new EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        EventData e = eventList.get(position);
        holder.name.setText(e.getName());
    }

    public int getItemCount() {
        return eventList.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        EventViewHolder(View v){
            super(v);
            name = v.findViewById(R.id.storyName);
        }
    }

}
