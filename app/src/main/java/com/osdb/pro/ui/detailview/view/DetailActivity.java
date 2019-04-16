package com.osdb.pro.ui.detailview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.osdb.pro.R;
import com.osdb.pro.ui.base.view.BaseActivity;

import com.osdb.pro.ui.player_details_screen.view.VideoPlayActivity;
import com.osdb.pro.utils.Tag;
import com.osdb.pro.utils.TagView;
import com.osdb.pro.utils.Utils;

import java.util.List;

public class DetailActivity extends BaseActivity implements View.OnClickListener {

    //Toolbar toolbar;
    AppBarLayout appBarLayout;
    private Menu collapsedMenu;
    private boolean appBarExpanded = true;
    private ImageView image, backImg, shareImg;
    private TextView header_txt, detail_txt, toolbarTxt, date_txt;
    private String headerText, longText, imgUrl;
    private int fileType;
    private ImageView locButton, video_icon;
    private List<Tag> slugName;
    private TagView view_game_name;
    private TextView txt_source;
    private String videoPath;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        image = findViewById(R.id.image);
        video_icon = findViewById(R.id.video_icon);
        header_txt = findViewById(R.id.header_txt);
        detail_txt = findViewById(R.id.detail_txt);
        toolbarTxt = findViewById(R.id.toolbarTxt);
        view_game_name = findViewById(R.id.view_game_name);
        backImg = findViewById(R.id.backImg);
        shareImg = findViewById(R.id.shareImg);
        txt_source = findViewById(R.id.txt_source);
        date_txt = findViewById(R.id.date_txt);
        backImg.setOnClickListener(this);
        shareImg.setOnClickListener(this);
        video_icon.setOnClickListener(this);

        setData(getIntent());


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.e("OFFSET", "onOffsetChanged: verticalOffset: " + Math.abs(verticalOffset));

                //  Vertical offset == 0 indicates appBar is fully expanded.

                if (Math.abs(verticalOffset) > 270) {
                    appBarExpanded = false;
                    backImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_back_black));
                    shareImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_share_black));
                    toolbarTxt.setVisibility(View.VISIBLE);
                } else {
                    appBarExpanded = true;
                    backImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_back));
                    shareImg.setImageDrawable(getResources().getDrawable(R.drawable.ic_share));
                    toolbarTxt.setVisibility(View.GONE);

                }
            }
        });
    }

    private void setData(Intent intent) {
        if (intent != null) {
            imgUrl = intent.getStringExtra("imgUrl");
            headerText = intent.getStringExtra("title");
            longText = intent.getStringExtra("bigContent");
            fileType = intent.getIntExtra("fileType", -1);
            slugName = (List<Tag>) intent.getSerializableExtra("teamName");
            String[] arrayString = (String[]) intent.getSerializableExtra("arrayString");
            String date = intent.getStringExtra("date");
            String source = intent.getStringExtra("source");
            String newsType = intent.getStringExtra("newsType");
            txt_source.setText(source != null ? source : "");

            if (imgUrl != null) {
                if (!imgUrl.contains(".jpg")) {
                    videoPath = imgUrl.concat(".mp4");
                    imgUrl = imgUrl.concat(".jpg");
                }
            }

            // set image
            if (newsType != null && newsType.equalsIgnoreCase("video")) {
                video_icon.setVisibility(View.VISIBLE);
            } else {
                video_icon.setVisibility(View.GONE);
            }
            if (imgUrl != null) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.place);
                Glide.with(this).setDefaultRequestOptions(requestOptions).load(imgUrl).into(image);
            }
            // set header text
            header_txt.setText(headerText != null ? headerText : "");

            // set big content
            detail_txt.setText(longText != null ? Html.fromHtml(longText).toString() : "");

            // set date and time stamp
            if (date != null) {
                long timeInLong = Utils.getLongTime(date, "MMM. dd, yyyy");
                date_txt.setText(date + "  " + Utils.getFullTimeAgo(timeInLong));
            } else {
                date_txt.setText("");
            }
            if (arrayString != null)
                view_game_name.addTags(arrayString);
            else
                view_game_name.addTags(slugName);

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.backImg:
                finish();
                break;

            case R.id.shareImg: {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("*/*");
                startActivity(Intent.createChooser(sharingIntent, "Share"));
            }
            case R.id.video_icon: {
                openVideoNews();
            }
        }
    }

    private void openVideoNews() {

        Intent intent = new Intent(this, VideoPlayActivity.class);
        intent.putExtra("PATH", videoPath);
        startActivity(intent);
    }
}

