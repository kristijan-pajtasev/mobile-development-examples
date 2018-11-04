package com.example003.example003;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "This is a long toast message", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "This is a short toast message", Toast.LENGTH_SHORT).show();
    }
}
