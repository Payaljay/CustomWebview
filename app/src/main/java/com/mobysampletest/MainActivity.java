package com.mobysampletest;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.dev.myapplication.FinestWebViewBuilder;

public class MainActivity extends AppCompatActivity {

    LinearLayout moLlLauncher;
    private static final String TEST_PAGE_URL = "https://app.mobyads.in/publisher/A01234567/?fsMobile=918140663133&fsEmail=johndeo@gmail.com&fsFirstName=Chirag&fsLastName=Kheni&fiDeviceType=0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initContent();
    }

    private void initContent() {

       /* String permission = Manifest.permission.CAMERA;
        int grant = ContextCompat.checkSelfPermission(this, permission);
        if (grant != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            permission_list[0] = permission;
            ActivityCompat.requestPermissions(this, permission_list, 1);
        }*/

        moLlLauncher = findViewById(R.id.llLaunch);
        moLlLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent loIntent = new Intent(MainActivity.this, WebActivity.class);
                // startActivity(loIntent);
                FinestWebViewBuilder builder = new FinestWebViewBuilder().
                        setAccessStorage(true).
                        setAccessGPS(true).
                        setUrl(TEST_PAGE_URL).
                        build();
                builder.loadWebView();
            }
        });

        TextView blinkText = (TextView) findViewById(R.id.blinkTextView);

        ObjectAnimator textColorAnim = ObjectAnimator.ofInt(blinkText, "textColor", Color.BLUE, Color.YELLOW);
        textColorAnim.setDuration(1000);
        textColorAnim.setEvaluator(new ArgbEvaluator());
        textColorAnim.setRepeatCount(ValueAnimator.INFINITE);
        textColorAnim.setRepeatMode(ValueAnimator.REVERSE);
        textColorAnim.start();

    }
}




