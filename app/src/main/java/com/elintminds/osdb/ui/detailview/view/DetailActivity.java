package com.elintminds.osdb.ui.detailview.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.utils.Tag;
import com.elintminds.osdb.utils.TagView;
import com.elintminds.osdb.utils.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DetailActivity extends BaseActivity implements View.OnClickListener {

    //Toolbar toolbar;
    AppBarLayout appBarLayout;
    private Menu collapsedMenu;
    private boolean appBarExpanded = true;
    private ImageView image, backImg, shareImg;
    private TextView header_txt, detail_txt, toolbarTxt, view_game_name, date_txt;
    private String headerText, longText, imgUrl, slugName;
    private ImageView locButton;
    private TagView tag_group;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        image = findViewById(R.id.image);
        header_txt = findViewById(R.id.header_txt);
        detail_txt = findViewById(R.id.detail_txt);
        toolbarTxt = findViewById(R.id.toolbarTxt);
        view_game_name = findViewById(R.id.view_game_name);
        backImg = findViewById(R.id.backImg);
        shareImg = findViewById(R.id.shareImg);
        date_txt = findViewById(R.id.date_txt);
        tag_group = findViewById(R.id.tag_group);
        backImg.setOnClickListener(this);
        shareImg.setOnClickListener(this);

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
            slugName = intent.getStringExtra("teamName");
            String[] arrayString = (String[]) intent.getSerializableExtra("arrayString");
            String date = intent.getStringExtra("date");
            // set image
            if (imgUrl != null) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.place);
                Glide.with(this).setDefaultRequestOptions(requestOptions).load(imgUrl).into(image);
            }

            // set header text
            header_txt.setText(headerText != null ? headerText : "");
            Utils.justify(header_txt);

            // set big content
            detail_txt.setText(longText != null ? Html.fromHtml(longText).toString() : "");

            // set date and time stamp
            if (date != null) {
//                String formatedDate = Utils.getFormatedDate(date, "yyyy-MM-dd hh:mm:ss", "MMM. dd, yyyy");
                long timeInLong = Utils.getLongTime(date, "MMM. dd, yyyy");
                date_txt.setText(date + "  " + Utils.getTimeAgo(timeInLong));
            } else {
                date_txt.setText("");
            }

//            set all tags
            if (arrayString != null && arrayString.length > 0) {
                List<Tag> tagList = new ArrayList<>();
                for (int i = 0; i < arrayString.length; i++) {
                    Tag tag = new Tag(arrayString[i]);
                    tag.setBackground(getDrawable(R.drawable.red_capsule_bg));
                    tagList.add(tag);
                }
                view_game_name.setVisibility(View.GONE);
                tag_group.setVisibility(View.VISIBLE);
                tag_group.addTags(tagList);
            } else {
                view_game_name.setVisibility(View.VISIBLE);
                tag_group.setVisibility(View.GONE);
            }

            view_game_name.setText(slugName != null ? slugName : "NFL");
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
        }
    }
}
