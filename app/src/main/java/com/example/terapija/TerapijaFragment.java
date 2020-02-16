package com.example.terapija;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class TerapijaFragment extends Fragment {
    FirebaseListAdapter<Therapy> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_terapija,container,false);
        ListView myListView= (ListView) view.findViewById(R.id.therapy_listview);

            Query query = FirebaseDatabase.getInstance().getReference("therapy");

        FirebaseListOptions<Therapy> options = new FirebaseListOptions.Builder<Therapy>()
                .setQuery(query, Therapy.class)
                .setLayout(R.layout.therapy_listview_layout)
                .build();
        //Finally you pass them to the constructor here:

        adapter = new FirebaseListAdapter<Therapy>(options) {
            @Override
            protected void populateView(View v, final Therapy therapy, int position) {
                TextView messageText = (TextView) v.findViewById(R.id.therapy_name);
                TextView messageType = (TextView) v.findViewById(R.id.therapy_type);

                // Set their text
                messageText.setText(therapy.getName());
                messageType.setText(therapy.getType());

                v.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), TherapyDetails.class);
                        intent.putExtra("TITLE", therapy.getName());
                        intent.putExtra("CONTENT", therapy.getType());
                        startActivity(intent);

                    }
                });
            }
        };
        myListView.setAdapter(adapter);
        if(adapter!=null)
        adapter.notifyDataSetChanged();


        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }


    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}
