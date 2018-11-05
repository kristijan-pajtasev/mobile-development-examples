package com.example008;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageDrawable(resources.getDrawable(R.mipmap.ic_launcher));
    }
}
