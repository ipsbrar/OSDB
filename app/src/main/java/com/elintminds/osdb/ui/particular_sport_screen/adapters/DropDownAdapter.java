package com.elintminds.osdb.ui.particular_sport_screen.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.dashboard.beans.SportsAdapterListBean;
import com.elintminds.osdb.ui.particular_sport_screen.beans.DropdownBean;

import java.util.ArrayList;

public class DropDownAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<SportsAdapterListBean> dataList;

    public DropDownAdapter(Context context, ArrayList<SportsAdapterListBean> dataList)
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

        SportsAdapterListBean item = dataList.get(i);

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

        holder.ddItem.setText(item.getName() != null ? item.getName() : "");
        if (item.getLogo().getFileName() != null &&  item.getLogo().getFileName().equalsIgnoreCase(""))
            Glide.with(context).load(item.getLogo().getFileName()).into(holder.ddImageItem);
        return view;
    }


    public class ViewHolder
    {
        TextView ddItem;
        ImageView ddImageItem;
        public ViewHolder(View view)
        {
            ddItem = view.findViewById(R.id.dd_item);
            ddImageItem = view.findViewById(R.id.sport_logo);
        }
    }
}
