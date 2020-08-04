package com.example.phonebook.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;


import com.example.phonebook.Fragments.AddNewFragment;
import com.example.phonebook.Fragments.ContactsFragment;
import com.example.phonebook.R;


public class MainActivity extends AppCompatActivity {

    //instances of fragments
    private ContactsFragment contactsFragment;
    private AddNewFragment addNewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        //initializing our fragments
        contactsFragment = new ContactsFragment();
        addNewFragment = new AddNewFragment();

        FrameLayout frameLayout = findViewById(R.id.fragment_container);

        //setting default fragment on launch
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, contactsFragment);
            fragmentTransaction.commit();
        }




    }
    /*BottomNavigationView navigation = findViewById(R.id.bottomNavigationView);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //switch statement goes here
                switch (item.getItemId()) {
                    case R.id.people:
                        InitializeFragment(contactsFragment);
                        return true;

                    case R.id.exit:
                        System.exit(0);
                        return true;
                }
                return false;
            }

        });

        if (savedInstanceState == null) {
            navigation.setSelectedItemId(R.id.people);   //setting people fragment as default
        } */



}




