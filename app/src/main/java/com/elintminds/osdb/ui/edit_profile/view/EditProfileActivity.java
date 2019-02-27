package com.elintminds.osdb.ui.edit_profile.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseActivity;

public class EditProfileActivity extends BaseActivity implements View.OnClickListener {

    private ImageView backImg;
    private TextView savebtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        savebtn= findViewById(R.id.save_btn);
        backImg= findViewById(R.id.back_img);
        backImg.setOnClickListener(this);
        savebtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.back_img:{
                finish();
                break;
            }

            case R.id.save_btn:{
                finish();
                break;
            }
        }
    }
}
