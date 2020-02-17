package com.example.terapija;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{

    private static final String TAG = "MyListAdapter";

    private List<Medicine> mMedicines= new ArrayList<>();
    private Context mContext;

    public MyListAdapter(Context context, List<Medicine> medicines) {
        mMedicines = medicines;
        mContext = context;
    }

    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, final int position) {
        holder.name.setText(mMedicines.get(position).getTitle());

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MedicineDetails.class);
                intent.putExtra("title", mMedicines.get(position).getTitle());
                intent.putExtra("description", mMedicines.get(position).getDescription());
                intent.putExtra("how_to_use", mMedicines.get(position).getHow_to_use());
                intent.putExtra("important_information", mMedicines.get(position).getImportant_information());
                intent.putExtra("before_taking", mMedicines.get(position).getBefore_taking());
                intent.putExtra("side_effects", mMedicines.get(position).getSide_effects());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMedicines.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.list_item_id);
        }
    }
}
