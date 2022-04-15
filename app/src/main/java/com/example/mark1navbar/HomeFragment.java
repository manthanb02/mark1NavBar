package com.example.mark1navbar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


public class HomeFragment extends Fragment {

    View view;

    String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    AutoCompleteTextView dropDownMonthMenu;
    ArrayAdapter<String> arrayAdapterMonth , arrayAdapterYear;

    String[] year ={"2022", "2023", "2024", "2025", "2026", "2027"};
    AutoCompleteTextView dropDownYearMenu;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }


    // in onViewCreated() we can use findViewById() as shown below :
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Code For Drop-down Menu of Month
        dropDownMonthMenu = (AutoCompleteTextView) view.findViewById(R.id.dropDown_monthMenu);//this is a way to use findViewById in fragment
        arrayAdapterMonth = new ArrayAdapter<String>(getActivity(),R.layout.list_month,month);
        dropDownMonthMenu.setAdapter(arrayAdapterMonth);
        dropDownMonthMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String month = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getActivity(), "selected month : "+month, Toast.LENGTH_SHORT).show();
            }
        });

        // Code For Drop-down Menu of Year
        dropDownYearMenu = (AutoCompleteTextView) view.findViewById(R.id.dropDown_yearMenu);
        arrayAdapterYear = new ArrayAdapter<String>(getActivity(),R.layout.list_year,year);
        dropDownYearMenu.setAdapter(arrayAdapterYear);
        dropDownYearMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String year = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getActivity(), "selected year : "+year, Toast.LENGTH_SHORT).show();
            }
        });

    }
}