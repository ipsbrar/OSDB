package com.elintminds.osdb.ui.particular_sport_screen.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.elintminds.osdb.R;
import com.elintminds.osdb.data.network.WebserviceUrls;
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamClubBean;
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamInfoBean;
import com.elintminds.osdb.ui.particular_sport_screen.beans.TeamsBean;
import com.elintminds.osdb.ui.particular_sport_screen.view.SportScreenView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TeamsViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<TeamClubBean> dataList;
    private SportScreenView.TeamsExpandableItemsListener listener;

    public TeamsViewAdapter(Context context, ArrayList<TeamClubBean> dataList, SportScreenView.TeamsExpandableItemsListener listener) {
        this.context = context;
        this.dataList = dataList;
        this.listener = listener;
    }

    @Override
    public int getGroupCount() {
        return dataList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return dataList.get(i).getTeamsList().size();
    }

    @Override
    public Object getGroup(int i) {
        return dataList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return dataList.get(i).getTeamsList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup parent) {
        GroupViewHolder holder;
        TeamClubBean headerTitle = (TeamClubBean) getGroup(i);
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.sports_expandable_group_view, parent, false);
            holder = new GroupViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (GroupViewHolder) view.getTag();
        }

        holder.clubName.setText(headerTitle.getTeamClubName());

        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup parent) {
        ChildViewHolder holder;
        TeamInfoBean.Team childItem = (TeamInfoBean.Team) getChild(i, i1);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.sports_expandable_child_view, parent, false);
            holder = new ChildViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ChildViewHolder) view.getTag();
        }

        holder.teamName.setText(childItem.getTeamName());
//        if(childItem.isFollowing())
//        {
//            holder.followBtn.setText(context.getString(R.string.following));
//            holder.followBtn.setSelected(childItem.isFollowing());
//        }
//        else {
        holder.followBtn.setText(context.getString(R.string.follow));
//            holder.followBtn.setSelected(childItem.isFollowing());
//        }

        if (childItem.getLogo() != null && !childItem.getLogo().equalsIgnoreCase("")) {
            try {
                JSONArray jsonArray = new JSONArray(childItem.getLogo());
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                String imgUrl = jsonObject.getString("href");
                String urlImg = "https://s3-us-west-2.amazonaws.com/osdb/" + imgUrl;
                Log.e("MYIMAGEURL", childItem.getTeamName() + "    " + urlImg);
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.empty_white);
                Glide.with(context).setDefaultRequestOptions(requestOptions).load(urlImg).into(holder.teamLogo);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        holder.teamName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onTeamClick(i, i1);
            }
        });

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public class GroupViewHolder {
        TextView clubName;

        GroupViewHolder(View view) {
            clubName = view.findViewById(R.id.lblListHeader);
        }
    }

    public class ChildViewHolder {
        TextView teamName;
        TextView followBtn;
        ImageView teamLogo;

        public ChildViewHolder(View view) {
            teamName = view.findViewById(R.id.teamName);
            followBtn = view.findViewById(R.id.follow_btn);
            teamLogo = view.findViewById(R.id.team_logo);
        }
    }
}
