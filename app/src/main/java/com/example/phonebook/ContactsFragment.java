package com.example.phonebook;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {

    public ContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        /*hiding app bar for this fragment, not necessary anymore but now we know how to do it lol
        View layout = inflater.inflate(R.layout.fragment_contacts, container, false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();*/


        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }
}
