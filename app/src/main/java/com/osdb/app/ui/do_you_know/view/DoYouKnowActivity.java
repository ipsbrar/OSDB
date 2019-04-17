package com.osdb.app.ui.do_you_know.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.osdb.app.R;
import com.osdb.app.ui.base.view.BaseActivity;

public class DoYouKnowActivity extends BaseActivity implements View.OnClickListener {

    private ImageView backImg, shareImg, imageView;
    private TextView detail_txt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_you_know);

        detail_txt = findViewById(R.id.detail_txt);
        shareImg = findViewById(R.id.share_img);
        imageView = findViewById(R.id.image);
        if (getIntent() != null) {

            String imgUrl = getIntent().getStringExtra("imgUrl");
            if (imgUrl != null) {
                RequestOptions requestOptions = new RequestOptions();
                requestOptions.placeholder(R.drawable.place);
                Glide.with(this).setDefaultRequestOptions(requestOptions).load(imgUrl).into(imageView);
            }

            String title = getIntent().getStringExtra("title");
            detail_txt.setText(Html.fromHtml(title).toString());

        }


        backImg = findViewById(R.id.back_img);
        backImg.setOnClickListener(this);
        shareImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
            case R.id.share_img: {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("*/*");
                startActivity(Intent.createChooser(sharingIntent, "Share  using"));
                break;
            }
        }
    }
}
