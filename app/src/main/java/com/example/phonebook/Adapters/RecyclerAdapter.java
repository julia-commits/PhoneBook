package com.example.phonebook.Adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonebook.DB.Contact;
import com.example.phonebook.R;
import com.example.phonebook.Viewholders.contactsViewHolder;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ContactItemHolder> {
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
    public ContactItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating item layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_card, parent, false);
        RecyclerAdapter.ContactItemHolder cv = new RecyclerAdapter.ContactItemHolder(v);
        return cv;
    }

    @Override
    public void onBindViewHolder(ContactItemHolder holder, int position) {
        Contact contact = listContacts.get(position);
        holder.contactName.setText(contact.getF_name());
        holder.contactNumber.setText(contact.getPhone());

        Bitmap bitmap = BitmapFactory.decodeByteArray(contact.getProfile_pic(), 0, contact.getProfile_pic().length);
        holder.contactImage.setImageBitmap(bitmap);
    }


    @Override
    public int getItemCount() {
        return listContacts.size();
    }

    static class ContactItemHolder extends RecyclerView.ViewHolder {
        TextView contactName,contactNumber;
        ImageView contactImage;

        public ContactItemHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contactName);
            contactNumber = itemView.findViewById(R.id.contactNumber);
            contactImage = itemView.findViewById(R.id.contactImage);
        }
    }
}
