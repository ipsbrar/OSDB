package com.elintminds.osdb.ui.event_details.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class EventDetailsActivity extends BaseActivity implements OnMapReadyCallback
{
    private Toolbar toolbar;
    private GoogleMap mMap;
    private TextView eventTitleOne, eventTitleTwo;
    private ImageView versusIcon;
    private String title1, title2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        initializeView();

        setSupportActionBar(toolbar);

        //Enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent recievedData = getIntent();
        if(recievedData != null)
        {
            title1 = recievedData.getStringExtra("TITLE_1");
            title2 = recievedData.getStringExtra("TITLE_2");
            Log.e("TITLES",""+title1+", "+title2);

            if(title2 != null)
            {
                eventTitleOne.setText(title1);
                eventTitleTwo.setText(title2);
            }
            else
            {
                eventTitleOne.setText(title1);
                versusIcon.setVisibility(View.GONE);
                eventTitleTwo.setVisibility(View.GONE);
            }
        }

    }

    private void initializeView()
    {
        toolbar = findViewById(R.id.event_details_toolbar);
        eventTitleOne = findViewById(R.id.event_title_one);
        eventTitleTwo = findViewById(R.id.event_title_two);
        versusIcon = findViewById(R.id.versus_view);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.event_details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        if(mMap != null) {

            try {
                mMap.setMapStyle(
                        MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style));
            }catch (Exception e)
            {
                Log.e("Map Exception", ""+e.toString());
            }

            LatLng location = new LatLng(51.5074, 0.1278);
            mMap.addMarker(new MarkerOptions().position(location));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 9f));
        }
    }
}
