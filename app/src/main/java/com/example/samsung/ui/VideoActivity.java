package com.example.samsung.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    public int video[]={R.raw.wildlife,R.raw.wildlife,0,R.raw.wildlife,0};
    public int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button back = findViewById(R.id.Back);
        setContentView(R.layout.activity_video);
        Bundle extras = getIntent().getExtras();
        i = extras.getInt("index");
        Log.d("video","is "+i);
        VideoView videoView = findViewById(R.id.videoView);
        String uriPath = "android.resource://" + getPackageName()+ "/" + video[i];
        if (video[i] == 0) {Toast.makeText(getApplicationContext(), "no video", Toast.LENGTH_SHORT).show();}

        else {
            Uri uri = Uri.parse(uriPath);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
