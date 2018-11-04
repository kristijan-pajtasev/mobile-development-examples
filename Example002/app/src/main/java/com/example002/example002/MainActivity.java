package com.example002.example002;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("MainActivity", "This is an information message");
        Log.w("MainActivity", "This is a warning message");
        Log.e("MainActivity", "This is an error message");
        Log.d("MainActivity", "This is a debug message");
        Log.v("MainActivity", "This is a verbose message which is reserved for really really long text");

        Log.wtf("MainActivity", "This is a WTF/Assertion Failure message. If an assertion fails in your code log it with this.");


    }
}
