package com.osdb.pro.ui.FilterActivity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.osdb.pro.R;

import java.util.ArrayList;

public class CustomSpinnerAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<String> stringArrayList;

    public CustomSpinnerAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.stringArrayList = objects;
    }


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // This funtion called for each row ( Called data.size() times )
    public View getCustomView(int position, View convertView, ViewGroup parent) {

        View row = LayoutInflater.from(context).inflate(R.layout.simple_spinner_item, parent, false);


        TextView label = row.findViewById(R.id.txt_spinner_item);


        label.setText(stringArrayList.get(position));


        return row;
    }


}
