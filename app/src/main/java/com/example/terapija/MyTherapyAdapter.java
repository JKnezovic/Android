package com.example.terapija;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyTherapyAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    public MyTherapyAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return DataStorage.listViewData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
            view = mInflater.inflate(R.layout.therapy_listview_layout, viewGroup, false);
        final TextView name = (TextView) view.findViewById(R.id.therapy_name);
        final TextView type = (TextView) view.findViewById(R.id.therapy_type);
        final Therapy therapy = DataStorage.listViewData.get(i);
        name.setText(therapy.getName());
        type.setText(therapy.getType());
        return view;
    }





}
