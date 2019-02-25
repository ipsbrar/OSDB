package com.elintminds.osdb.ui.add_edit_discussion.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;
import com.elintminds.osdb.ui.login.view.LoginActivity;
import com.elintminds.osdb.ui.register.view.RegisterActivity;

public class AddEditDiscussionActivity extends BaseActivity implements View.OnClickListener {

    private TextView addDiscussionBtn;
    private ImageView backImg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_discussion_view);

        initializeViews();
    }

    private void initializeViews()
    {
        addDiscussionBtn = findViewById(R.id.add_btn);
        backImg = findViewById(R.id.backImg);

        addDiscussionBtn.setOnClickListener(this);
        backImg.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.add_btn:
                finish();
                break;

            case R.id.backImg:
                finish();
                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
