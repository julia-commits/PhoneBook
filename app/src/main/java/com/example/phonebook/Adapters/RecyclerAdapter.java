package com.example.phonebook.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonebook.R;
import com.example.phonebook.Viewholders.contactsViewHolder;


public class RecyclerAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating item layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_card, parent, false);
        contactsViewHolder cv = new contactsViewHolder(v);
        return cv;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
