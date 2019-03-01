package com.elintminds.osdb.ui.do_you_know.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;

public class DoYouKnowActivity extends BaseActivity implements View.OnClickListener {

    private ImageView backImg, shareImg;
    private TextView detail_txt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_you_know);

        detail_txt = findViewById(R.id.detail_txt);
        if (getIntent() != null) {

            String title = getIntent().getStringExtra("title");
            detail_txt.setText(Html.fromHtml(title).toString());

        }


        backImg = findViewById(R.id.back_img);
        backImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.back_img:
                finish();
                break;
        }
    }
}
