package com.osdb.android.ui.player_details_screen.view;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.osdb.android.R;
import com.osdb.android.ui.base.view.BaseActivity;

public class VideoPlayActivity extends BaseActivity {
    private VideoView vv_video_play;
    private MediaController mediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video_play);
        initView();
    }

    private void initView() {
        vv_video_play = findViewById(R.id.vv_video_play);
        Intent intent = getIntent();
        if (intent != null) {
            String path = intent.getStringExtra("PATH");
            if (path != null && !path.equalsIgnoreCase("")) {
                playVideo(path);
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
                finish();
            }

        } else {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            finish();
        }
    }


    public void playVideo(String videopath) {
        Log.e("entered", "playvide");
        Log.e("path is", "" + videopath);
        try {

            showProgressDialog();
            getWindow().setFormat(PixelFormat.TRANSLUCENT);

            mediaController = new MediaController(this);

            Uri video = Uri.parse(videopath);
            vv_video_play.setMediaController(mediaController);
            vv_video_play.setVideoURI(video);

            vv_video_play.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer mp) {
                    hideProgressDialog();
                    vv_video_play.start();
                }
            });

        } catch (Exception e) {
            hideProgressDialog();
            Log.e("Video_Play_Error :", e.getMessage());
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        hideProgressDialog();
        finish();
    }
}
