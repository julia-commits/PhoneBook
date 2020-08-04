package com.example.phonebook.Fragments;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.phonebook.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.Calendar;
import java.util.Objects;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewFragment extends Fragment {
    EditText dateSelect;


    public AddNewFragment() {
        // Required empty public constructor
    }

    //variables
    private Toolbar toolbar;
    ImageView profile;
    FloatingActionButton fab;
    private static final int REQUEST_CAMERA = 1;
    private static final int SELECT_FILE = 2;
    Uri imageUri;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //toolbar menu options
        setHasOptionsMenu(true);
        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).show();


        View view = inflater.inflate(R.layout.fragment_add_new, container, false);

        //fab icon image capture
        profile = (ImageView) view.findViewById(R.id.profile);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext()); //Read Update
                alertDialog.setTitle("Choose:");
                alertDialog.setItems(new CharSequence[]
                        {"Camera", "Gallery", "Cancel"},
                        new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which) {
                            case 0:
                                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                startActivityForResult(camera, REQUEST_CAMERA);
                                break;

                            case 1:
                                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                                startActivityForResult(gallery, SELECT_FILE);
                                break;

                            case 2:
                                dialog.cancel();
                        }
                    }
                });

                alertDialog.create().show();
            }

        });



    //datepicker
    dateSelect =(EditText)view.findViewById(R.id.date);
        dateSelect.setOnClickListener(new View.OnClickListener()

    {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick (View v){
        Calendar currentDate = Calendar.getInstance();

        int mDay = currentDate.get(Calendar.DAY_OF_MONTH);
        int mMonth = currentDate.get(Calendar.MONTH);
        int mYear = currentDate.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(Objects.requireNonNull(getActivity()), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                dateSelect.setText(date);
            }
        },
                mDay,
                mMonth,
                mYear);
        datePickerDialog.show();

    }
    });

        return view;

}


//saving captured image
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CAMERA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            assert extras != null;
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            profile.setImageBitmap(imageBitmap);
        }
        else if(requestCode == SELECT_FILE){
            if(data!=null) {
                imageUri = data.getData();
                profile.setImageURI(imageUri);
            }

        }
    }



    //toolbar

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.navmenu, menu);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                Toast.makeText(getContext(),"Save button clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.cancel:
                Toast.makeText(getContext(), "Cancel button clicked", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

