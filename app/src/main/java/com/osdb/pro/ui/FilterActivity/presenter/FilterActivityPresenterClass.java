package com.osdb.pro.ui.FilterActivity.presenter;

import android.content.Context;
import com.osdb.pro.data.app_prefs.AppPreferenceHelperClass;
import com.osdb.pro.ui.FilterActivity.Modal.FilterActivityInteractor;
import com.osdb.pro.ui.FilterActivity.Modal.FilterActivityInteractorClass;
import com.osdb.pro.ui.FilterActivity.view.FilterActivityView;
import com.osdb.pro.ui.base.presenter.BasePresenterClass;

import java.util.ArrayList;
import java.util.Calendar;

public class FilterActivityPresenterClass<V extends FilterActivityView, I extends FilterActivityInteractor> extends BasePresenterClass<V, I> implements FilterActivityPresenter<V, I> {

    public FilterActivityPresenterClass(Context context, I interactor, V view) {
        super(context, interactor, view);
    }

    public FilterActivityPresenterClass(Context context, V view) {
        this(context, (I) new FilterActivityInteractorClass(new AppPreferenceHelperClass(context), context), view);
    }

    private ArrayList<String> yearList() {
        ArrayList<String> yearList = new ArrayList<>();

        int year = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = year; i >= 2000; i--) {
            yearList.add(String.valueOf(i));
        }
        return yearList;
    }

    private ArrayList<String> seasonList() {
        ArrayList<String> seasonList = new ArrayList<>();
        seasonList.add("PRE");
        seasonList.add("REG");
        seasonList.add("PST");

        return seasonList;
    }

    private ArrayList<String> weeklyList(String season) {
        if (season.equalsIgnoreCase("PRE")) {
            return weeklyPreData();
        } else if (season.equalsIgnoreCase("REG")) {
            return weeklyRegData();
        } else {
            return weeklyPstData();
        }

    }

    private ArrayList<String> weeklyPreData() {
        ArrayList<String> WeeklyPreData = new ArrayList<>();
        WeeklyPreData.add("Hall of fame weekend");
        for (int i = 1; i <= 4; i++) {
            WeeklyPreData.add("Preseason week " + i);
        }

        return WeeklyPreData;
    }

    private ArrayList<String> weeklyRegData() {
        ArrayList<String> WeeklyRegData = new ArrayList<>();
        for (int i = 1; i <= 17; i++) {
            WeeklyRegData.add("Week " + i);
        }

        return WeeklyRegData;
    }

    private ArrayList<String> weeklyPstData() {
        ArrayList<String> WeeklyPstData = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            WeeklyPstData.add("Postseason week " + i);
        }
        WeeklyPstData.add("Pro Bowl");
        WeeklyPstData.add("Divisional Round");
        WeeklyPstData.add("Conference ChampionShip");
        WeeklyPstData.add("Wild Card");
        WeeklyPstData.add("Super Bowl");

        return WeeklyPstData;
    }

    @Override
    public void getSeasonData() {
        getMvpView().getSeasonData(seasonList(),yearList());
    }

    @Override
    public void getWeeklyData(String season) {
        getMvpView().getData(weeklyList(season));
    }
}