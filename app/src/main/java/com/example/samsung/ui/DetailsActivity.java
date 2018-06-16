package com.example.samsung.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(DetailsActivity.this,MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_image:
                    return true;
                case R.id.navigation_video:
                    Intent video = new Intent(DetailsActivity.this,VideoActivity.class);
                    video.putExtra("index",j);
                    startActivityForResult(video,1);
                    return true;
            }
            return false;
        }
    };
        public int j = 0;
        public int i;
        private TextView text;
        private TextView textDetail;
        private String textArr[][]={{"Remove Window Trim and Casing",
                "Remove Old Window/Guide Track",
                "Prep/Repair New Window Opening",
                "Inspect/Replace Window Stop"},

                {"sop2.detail1","sop2.detail2","sop2.detail3","sop2.detail4"},
                {"sop3.detail1","sop3.detail2","sop3.detail3","sop3.detail4"},
                {"sop4.detail1","sop4.detail2","sop4.detail3","sop4.detail4"}};

        private String textDetails[][]={{"The first thing to do is to use a prybar to remove the window trim and jamb extension from around the old window. The jam extension is just...",
                "Unscrew the window from the jamb and remove it. Take care not to break the glass while removing. Many windows will be multiple window sashes with moving tracks on the side...",
                "With the window out of the wall, inspect the condition of the window jamb to make sure there is no structural damage. It’s not uncommon for an old window to leak, rotting out the jamb.... ",
                "The window stop is a piece of wood ripped down and placed around the exterior side of the window jamb. The function of the stop is to prevent..."},

                {"sop2.detail1","sop2.detail2","sop2.detail3","sop2.detail4"},
                {"sop3.detail1","sop3.detail2","sop3.detail3","sop3.detail4"},
                {"sop4.detail1","sop4.detail2","sop4.detail3","sop4.detail4"}};

        //public int imgArr[]={0,0,R.drawable.one,R.drawable.two};
      //  public int video[]={R.raw.wildlife,R.raw.demo3,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Bundle extras = getIntent().getExtras();
        i = extras.getInt("index");
        Log.d("index","is   "+i);
        Log.d("index","is   "+j);
        text = findViewById(R.id.text);
        textDetail = findViewById(R.id.textDetail);
        text.setText(textArr[i][j]);
        textDetail.setText(textDetails[i][j]);
        Button pre = findViewById(R.id.prev);
        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (j++ < (textArr[i].length-1))
                { text.setText(textArr[i][j]);
                    textDetail.setText(textDetails[i][j]);}
                else {
                    j = 0;
                    text.setText(textArr[i][j]);
                    textDetail.setText(textDetails[i][j]);
                }

            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (j-- > 0) {
                    Log.d("index","is   "+j);
                    text.setText(textArr[i][j]);
                    textDetail.setText(textDetails[i][j]);
                } else {
                    j = (textArr.length-1);
                    Log.d("index","is   "+j);
                    text.setText(textArr[i][j]);
                    textDetail.setText(textDetails[i][j]);
                }
            }
        });
        }
    }

