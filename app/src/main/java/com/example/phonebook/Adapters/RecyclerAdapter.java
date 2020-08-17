package com.example.phonebook.Adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonebook.DB.Contact;
import com.example.phonebook.R;
import com.example.phonebook.Viewholders.contactsViewHolder;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList <Contact> listContacts;
    private ArrayList<Contact> mArrayList;

    private SQLiteDatabase mDatabase;

    public RecyclerAdapter(Context context, ArrayList<Contact>listContacts) {
        //assigning them locally
        this.context = context;
        this.listContacts = listContacts;
        this.mArrayList = mArrayList;
        this.mDatabase = mDatabase;
    }

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
        Contact contact = listContacts.get(position);
        holder.contactName.setText(contact.getF_name());
        holder.contactNumber.setText(contact.getPhone());
        holder.contactImage.setImage(contact.getProfile_pic());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
