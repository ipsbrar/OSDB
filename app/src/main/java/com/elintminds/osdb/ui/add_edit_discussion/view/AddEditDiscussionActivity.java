package com.elintminds.osdb.ui.add_edit_discussion.view;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;

public class AddEditDiscussionActivity extends BaseActivity implements View.OnClickListener {

    private TextView addDiscussionBtn;
    private ImageView backImg;
    private EditText addDiscussionEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_discussion_view);

        initializeViews();
    }

    private void initializeViews() {
        addDiscussionBtn = findViewById(R.id.add_btn);
        addDiscussionEt = findViewById(R.id.add_discussion_et);
        backImg = findViewById(R.id.backImg);
        addDiscussionEt.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                Log.e("KEYEVENT",keyCode+"");
                if (event.getAction() == KeyEvent.KEYCODE_BACK) {
                    finish();
                } else if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    finish();
                } else {
                    finish();
                }
                return false;
            }

        });
        addDiscussionBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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
        finish();
    }

}
