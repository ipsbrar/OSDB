package com.osdb.android.ui.add_edit_discussion.view;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.osdb.android.R;
import com.osdb.android.ui.base.view.BaseActivity;
import com.osdb.android.utils.CustomEditText;

public class AddEditDiscussionActivity extends BaseActivity implements View.OnClickListener {

    private TextView addDiscussionBtn;
    private ImageView backImg;
private CustomEditText customEditText;
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
        customEditText = findViewById(R.id.txt_add_comment);

        customEditText.setKeyImeChangeListener(new CustomEditText.KeyImeChange() {
            @Override
            public void onKeyIme(int keyCode, KeyEvent event) {
                if (KeyEvent.KEYCODE_BACK == event.getKeyCode())
                {
                    // do something
                    Log.e("AddDiscussion_activity","KeyEvent");
                    finish();
                }
            }
        });

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
        Log.e("AddDiscussion_activity","onBackPressed");
        super.onBackPressed();
        finish();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks whether a hardware keyboard is available
        if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
            Toast.makeText(this, "keyboard visible", Toast.LENGTH_SHORT).show();
        } else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
            Toast.makeText(this, "keyboard hidden", Toast.LENGTH_SHORT).show();
        }
    }
}
