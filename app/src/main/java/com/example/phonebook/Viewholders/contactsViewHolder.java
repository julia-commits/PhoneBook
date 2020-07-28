package com.example.phonebook.Viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonebook.R;

public class contactsViewHolder extends RecyclerView.ViewHolder {
    private TextView contactName;
    private TextView contactNumber;
    private ImageView contactImage;

    public contactsViewHolder(@NonNull View itemView) {
        super(itemView);

        contactName = itemView.findViewById(R.id.contactName);
        contactNumber = itemView.findViewById(R.id.contactNumber);
        contactImage = itemView.findViewById(R.id.contactImage);

    }
}
