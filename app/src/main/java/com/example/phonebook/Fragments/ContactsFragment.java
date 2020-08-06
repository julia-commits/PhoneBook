package com.example.phonebook.Fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phonebook.Adapters.RecyclerAdapter;
import com.example.phonebook.DB.Contact;
import com.example.phonebook.Fragments.AddNewFragment;
import com.example.phonebook.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactsFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter RecyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private AddNewFragment addNewFragment;

    public ContactsFragment() {
        // Required empty public constructor
    }

    FloatingActionButton fab;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container,false);

        // Inflate the layout for this fragment

        addNewFragment = new AddNewFragment();

        fab = (FloatingActionButton) view.findViewById(R.id.fab); // to prevent a null pointer exception from being thrown
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentTransaction transaction=getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,addNewFragment); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();

            }
        });


        // lines to create RecyclerView in fragment
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new RecyclerAdapter());



        //hiding app bar for this fragment, not necessary anymore but now we know how to do it lol now we need it
        View layout = inflater.inflate(R.layout.fragment_contacts, container, false);
        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).hide();


        return view;


           }


}
