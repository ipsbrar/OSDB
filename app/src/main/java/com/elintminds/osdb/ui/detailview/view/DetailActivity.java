package com.elintminds.osdb.ui.detailview.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.utils.Utils;

public class DetailActivity extends BaseActivity {

    Toolbar toolbar;
    AppBarLayout appBarLayout;
    private Menu collapsedMenu;
    private boolean appBarExpanded = true;
    private ImageView image;
    private TextView header_txt, detail_txt;
    private String headerText, longText, imgUrl;
    private ImageView locButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        image = findViewById(R.id.image);
        header_txt = findViewById(R.id.header_txt);
        detail_txt = findViewById(R.id.detail_txt);


        if (getIntent() != null) {
            imgUrl = getIntent().getStringExtra("imgUrl");
            headerText = getIntent().getStringExtra("title");
            longText = getIntent().getStringExtra("bigContent");

            if (imgUrl != null)
                Glide.with(this).load(imgUrl).into(image);
            if (headerText != null) {
                header_txt.setText(headerText);
                Utils.justify(header_txt);
            }
            if (longText != null) {
                detail_txt.setText(Html.fromHtml(longText).toString());
//                Utils.justify(detail_txt);
            }

        }

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        //Set collapse & expanded title color
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLACK);

        //Set the title on collapsing toolbar
        collapsingToolbarLayout.setTitle("News");

        setSupportActionBar(toolbar);

        //Enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.e("OFFSET", "onOffsetChanged: verticalOffset: " + Math.abs(verticalOffset));

                //  Vertical offset == 0 indicates appBar is fully expanded.

                if (Math.abs(verticalOffset) > 270) {
                    appBarExpanded = false;
                    toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back_black));
                    if (locButton != null)
                        locButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_share_black));
                    invalidateOptionsMenu();
                } else {
                    appBarExpanded = true;
                    toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
                    if (locButton != null)
                        locButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_share));
                    invalidateOptionsMenu();
                }
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (collapsedMenu != null
                && (!appBarExpanded || collapsedMenu.size() != 1)) {

            locButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_share_black));
            //collapsed
//            collapsedMenu.add("")
//                    .setIcon(R.drawable.ic_share_black)
//                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        } else {
//            collapsedMenu.add("Share")
//                    .setIcon(R.drawable.ic_share)
//                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
            locButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_share));
        }
        return super.onPrepareOptionsMenu(collapsedMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        collapsedMenu = menu;
        locButton = (ImageView) menu.findItem(R.id.action_settings).getActionView();
        locButton.setPadding(30, 0, 30, 0);
locButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("*/*");
        startActivity(Intent.createChooser(sharingIntent, "Share  using"));
    }
});
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("*/*");
            startActivity(Intent.createChooser(sharingIntent, "Share  using"));
            return true;
        }else
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
