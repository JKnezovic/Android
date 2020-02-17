package com.example.terapija;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class PodsjetniciFragment extends Fragment {
    FirebaseListAdapter<Reminder> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_podsjetnici, container, false);
        ListView myListView = (ListView) view.findViewById(R.id.reminder_listview);


        Query query = FirebaseDatabase.getInstance().getReference("reminder");

        FirebaseListOptions<Reminder> options = new FirebaseListOptions.Builder<Reminder>()
                .setQuery(query, Reminder.class)
                .setLayout(R.layout.reminder_listview_item)
                .build();
        //Finally you pass them to the constructor here:

        adapter = new FirebaseListAdapter<Reminder>(options) {
            @Override
            protected void populateView(View v, final Reminder reminder, int position) {
                TextView name = (TextView) v.findViewById(R.id.reminder_name);
                TextView time = (TextView) v.findViewById(R.id.reminder_time);
                TextView amount = (TextView) v.findViewById(R.id.reminder_amount);

                // Set their text
                name.setText(reminder.getName());
                time.setText(reminder.getTime()+"h");
                amount.setText(String.valueOf(reminder.getAmount()));
            }
        };
        myListView.setAdapter(adapter);
        if (adapter != null)
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