package com.elintminds.osdb.ui.FilterActivity.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.FilterActivity.Adapter.CustomSpinnerAdapter;
import com.elintminds.osdb.ui.base.view.BaseActivity;

import java.util.ArrayList;

public class FilterActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner_cat, spinner_sub_cat, spinner_year;
    String[] strings = new String[]{"REG", "PRE", "POS"};
    ArrayList<String> arrayList = new ArrayList<>();
    private CustomSpinnerAdapter customSpinnerAdapter;

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
        arrayList.add("REG");
        arrayList.add("PRE");
        arrayList.add("PST");

        customSpinnerAdapter = new CustomSpinnerAdapter(this, R.layout.simple_spinner_item, arrayList);
        spinner_cat.setAdapter(customSpinnerAdapter);
        customSpinnerAdapter = new CustomSpinnerAdapter(this, R.layout.simple_spinner_item, arrayList);
        spinner_sub_cat.setAdapter(customSpinnerAdapter);
        customSpinnerAdapter = new CustomSpinnerAdapter(this, R.layout.simple_spinner_item, arrayList);
        spinner_year.setAdapter(customSpinnerAdapter);

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
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinner_cat: {
//                Toast.makeText(this, "spinner_cat", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.spinner_sub_cat: {
//                Toast.makeText(this, "spinner_sub_cat", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.spinner_year: {
//                Toast.makeText(this, "spinner_year", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
