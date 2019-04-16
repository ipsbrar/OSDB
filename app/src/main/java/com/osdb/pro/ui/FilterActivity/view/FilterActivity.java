package com.osdb.pro.ui.FilterActivity.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.osdb.pro.R;
import com.osdb.pro.ui.FilterActivity.Adapter.CustomSpinnerAdapter;
import com.osdb.pro.ui.FilterActivity.presenter.FilterActivityPresenterClass;
import com.osdb.pro.ui.base.view.BaseActivity;
import com.osdb.pro.ui.dashboard.view.DashboardActivity;

import java.util.ArrayList;

public class FilterActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, FilterActivityView {
    private Spinner spinner_cat, spinner_sub_cat, spinner_year;

    ArrayList<String> arrayList = new ArrayList<>();
    private CustomSpinnerAdapter customSpinnerAdapter;
    private FilterActivityPresenterClass filterActivityPresenterClass;
    private int check = 0;
    private DashboardActivity.OnFilterClick onFilterClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        setUpUi();
    }

    private void setUpUi() {


        spinner_cat = findViewById(R.id.spinner_cat);
        spinner_sub_cat = findViewById(R.id.spinner_sub_cat);
        spinner_year = findViewById(R.id.spinner_year);
        filterActivityPresenterClass = new FilterActivityPresenterClass(this, this);

        filterActivityPresenterClass.getSeasonData();
        filterActivityPresenterClass.getWeeklyData("PRE");
        spinner_sub_cat.setOnItemSelectedListener(this);
        spinner_cat.setOnItemSelectedListener(this);
        spinner_year.setOnItemSelectedListener(this);

        findViewById(R.id.signin_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.backImg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.signin_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAppPreferenceHelperClass().saveSeason((String) spinner_cat.getSelectedItem());
                getAppPreferenceHelperClass().saveYear((String) spinner_year.getSelectedItem());
                getAppPreferenceHelperClass().saveWeekly((String) spinner_sub_cat.getSelectedItem());
                Intent intent = new Intent();
                setResult(101, intent);
                finish();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (++check > 3) {
            switch (parent.getId()) {
                case R.id.spinner_cat: {

                    filterActivityPresenterClass.getWeeklyData((String) parent.getItemAtPosition(position));
                    break;
                }
                case R.id.spinner_sub_cat: {
                    break;
                }
                case R.id.spinner_year: {
                    break;
                }
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void getData(ArrayList<String> weeklyList) {
        customSpinnerAdapter = new CustomSpinnerAdapter(this, R.layout.simple_spinner_item, weeklyList);
        spinner_sub_cat.setAdapter(customSpinnerAdapter);


    }

    @Override
    public void getSeasonData(ArrayList<String> seasonList, ArrayList<String> yearList) {
        customSpinnerAdapter = new CustomSpinnerAdapter(this, R.layout.simple_spinner_item, seasonList);
        spinner_cat.setAdapter(customSpinnerAdapter);
        customSpinnerAdapter = new CustomSpinnerAdapter(this, R.layout.simple_spinner_item, yearList);
        spinner_year.setAdapter(customSpinnerAdapter);
    }
}