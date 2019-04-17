package com.osdb.app.ui.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.osdb.app.R;
import com.osdb.app.ui.dashboard.Interfaces.BornTodayOnClick;
import com.osdb.app.ui.dashboard.beans.HomeBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BornTodayAdapter extends RecyclerView.Adapter<BornTodayAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeBean.BornToday> dataList;
    private BornTodayOnClick bornTodayOnClick;

    public BornTodayAdapter(Context context, ArrayList<HomeBean.BornToday> dataList, BornTodayOnClick bornTodayOnClick) {
        this.context = context;
        this.dataList = dataList;
        this.bornTodayOnClick = bornTodayOnClick;
        Log.e("DATA BORN", "" + dataList.size());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.born_today_adapter_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        HomeBean.BornToday item = dataList.get(i);

        holder.playerNameTV.setText(item.getFullName());
        holder.birthDateTV.setText(getDobFormat(item.getDateOfBirth()));
        holder.ageTV.setText(getAge(item.getDateOfBirth()));
        if (item.getHeadshot() != null && item.getHeadshot().size() > 0 && item.getHeadshot().get(0).getHref() != null) {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.placeholder(R.drawable.place);
            Glide.with(context).setDefaultRequestOptions(requestOptions).load(item.getHeadshot().get(0).getHref()).into(holder.playerImage);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView playerImage;
        TextView playerNameTV, ageTV, birthDateTV;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerImage = itemView.findViewById(R.id.player_image);
            playerNameTV = itemView.findViewById(R.id.playerName);
            ageTV = itemView.findViewById(R.id.ageTxt);
            birthDateTV = itemView.findViewById(R.id.bornTxt);
            cardView = itemView.findViewById(R.id.cv_born_today);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String filePath = "";
                    if (dataList.get(getAdapterPosition()).getHeadshot() != null
                            && dataList.get(getAdapterPosition()).getHeadshot().size() > 0
                            && dataList.get(getAdapterPosition()).getHeadshot().get(0).getHref() != null) {
                        filePath = dataList.get(getAdapterPosition()).getHeadshot().get(0).getHref();
                    }

                    bornTodayOnClick.bornTodayOnCLick(dataList.get(getAdapterPosition()).getDateOfBirth(),
                            "NFL",
                            "NFL",
                            String.valueOf(dataList.get(getAdapterPosition()).getId()),
                            dataList.get(getAdapterPosition()).getFullName(),
                            filePath,
                            String.valueOf(dataList.get(getAdapterPosition()).getAge())
                    );
                }
            });
        }
    }

    ////AGE,TEAM_NAME,DIVISION_NAME,PLAYER_ID,PLAYER_NAME
    public void setDataList(ArrayList<HomeBean.BornToday> data) {
        if (data == null || data.isEmpty()) {
            return;
        }

        this.dataList = data;
    }

    private String getDobFormat(String dob) {
        //1989-02-25
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date newDate = null;
        try {
            newDate = spf.parse(dob);
            spf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            dob = spf.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dob;
    }


    private String getAge(String dob) {
        //1989-02-25
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        int currYear = Calendar.getInstance().get(Calendar.YEAR);
        Log.e("CURR YEAR", "" + currYear);
        int age = 0;
        Date newDate = null;
        try {
            newDate = spf.parse(dob);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(newDate);
            int dobYear = calendar.get(Calendar.YEAR);
            age = currYear - dobYear;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(age);
    }
}
