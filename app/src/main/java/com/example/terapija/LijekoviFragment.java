package com.example.terapija;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LijekoviFragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lijekovi, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);

        //layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        new FirebaseDatabaseHelper("drugs").readMedicine(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Medicine> medicines, List<String> keys) {
                MyListAdapter listAdapter = new MyListAdapter(getActivity(), medicines);
                recyclerView.setAdapter(listAdapter);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

        //list adapter



        return view;
        }


    }

