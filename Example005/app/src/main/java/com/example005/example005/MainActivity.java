package com.example005.example005;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get plural from the resources and apply it to a string for testing
        Resources resources = getResources();
        String textViewContent = resources.getQuantityString(R.plurals.dollar_plura, 1, 1);

        // pull the textView from the layout and set the string
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(textViewContent);
    }
}
