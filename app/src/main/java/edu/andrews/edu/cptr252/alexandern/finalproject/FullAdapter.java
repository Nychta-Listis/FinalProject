package edu.andrews.edu.cptr252.alexandern.finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FullAdapter extends RecyclerView.Adapter<FullAdapter.EventViewHolder>{


    private List<EventData> eventList;
    FullAdapter(List<EventData> list) {eventList = list;}

    public void setEventList(List<EventData> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public FullAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventFull_cell, parent, false);
        return new FullAdapter.EventViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FullAdapter.EventViewHolder holder, int position) {
        EventData e = eventList.get(position);
        holder.name.setText(e.getName());
        holder.id.setText(e.getId());
    }

    public int getItemCount() {
        return eventList.size();
    }

    static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView id;
        EventViewHolder(View v){
            super(v);
            name = v.findViewById(R.id.txtName);
            id = v.findViewById(R.id.txtId);
        }
    }
}
