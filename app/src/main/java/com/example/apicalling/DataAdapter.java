package com.example.apicalling;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<ToDo> android;

    public DataAdapter(ArrayList<ToDo> android) {
        this.android=android;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listview_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.userId.setText(android.get(i).getUserid());
        viewHolder.id.setText(android.get(i).getId());
        viewHolder.title.setText(android.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userId, id, title;

        public ViewHolder(View view) {
            super(view);
            userId = view.findViewById(R.id.user_id);
            id = view.findViewById(R.id.id);
            title =view.findViewById(R.id.title);
        }
    }
}
