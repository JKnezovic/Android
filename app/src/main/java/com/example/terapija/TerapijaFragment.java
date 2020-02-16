package com.example.terapija;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class TerapijaFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_terapija,container,false);
        ListView myListView= (ListView) view.findViewById(R.id.therapy_listview);
        DataStorage.fillData();
        myListView.setAdapter(new MyTherapyAdapter(getActivity().getApplicationContext()));

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(getActivity(), TherapyDetails.class);
                myIntent.putExtra("POZICIJA",position);

                startActivity(myIntent);
            }
        });

        return view;
    }

}
