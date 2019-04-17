package com.osdb.app.ui.search_finding_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.osdb.app.R;
import com.osdb.app.ui.search_finding_screen.beans.ScheduleBean;

import java.util.ArrayList;

public class SchedulesAdapter extends RecyclerView.Adapter<SchedulesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ScheduleBean> dataList;

    public SchedulesAdapter(Context context, ArrayList<ScheduleBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.schedules_adapter_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ScheduleBean scheduleBean = dataList.get(i);
        viewHolder.team_one_name.setText(scheduleBean.getTeamOneName());
        viewHolder.team_two_name.setText(scheduleBean.getTeamTwoName());
        viewHolder.schedule_address.setText(scheduleBean.getMatchAddres());
        viewHolder.schedule_time.setText(scheduleBean.getMatchTime());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView team_one_name, team_two_name, schedule_address, schedule_time;
        private ImageView team_one_logo, team_two_logo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            team_one_name = itemView.findViewById(R.id.team_one_name);
            team_two_name = itemView.findViewById(R.id.team_two_name);
            schedule_address = itemView.findViewById(R.id.schedule_address);
            schedule_time = itemView.findViewById(R.id.schedule_time);
            team_one_logo = itemView.findViewById(R.id.team_one_logo);
            team_two_logo = itemView.findViewById(R.id.team_two_logo);

        }
    }

    public void setDataList(ArrayList<ScheduleBean> data) {
        Log.e("DATA", "" + data);
        if (data == null || data.isEmpty()) {
            return;
        }

        this.dataList = data;
        Log.e("DA LIST", "" + dataList.size());
    }
}
