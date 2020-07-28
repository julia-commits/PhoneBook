package com.example.phonebook.Fragments;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.phonebook.R;

import java.util.Calendar;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewFragment extends Fragment {
    EditText dateSelect;


    public AddNewFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new, container, false);
        // Inflate the layout for this fragment

        //datepicker
        dateSelect = (EditText)view.findViewById(R.id.date);
        dateSelect.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
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





    }

