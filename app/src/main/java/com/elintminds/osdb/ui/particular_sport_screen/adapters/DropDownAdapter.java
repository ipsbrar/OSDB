package com.elintminds.osdb.ui.particular_sport_screen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.particular_sport_screen.beans.DropdownBean;

import java.util.ArrayList;

public class DropDownAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<DropdownBean> dataList;

    public DropDownAdapter(Context context, ArrayList<DropdownBean> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount()
    {
        return dataList.size();
    }

    @Override
    public Object getItem(int i)
    {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent)
    {
        ViewHolder holder;

        DropdownBean item = dataList.get(i);

        if (view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.simple_list_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        holder.ddItem.setText(item.getItemName());
        return view;
    }


    public class ViewHolder
    {
        TextView ddItem;
        public ViewHolder(View view)
        {
            ddItem = view.findViewById(R.id.dd_item);
        }
    }
}
