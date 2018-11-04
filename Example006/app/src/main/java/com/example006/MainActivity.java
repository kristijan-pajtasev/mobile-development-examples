package com.example006;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();
        TypedArray typedStringArray = resources.obtainTypedArray(R.array.my_string_array);
        TypedArray typedIntArray = resources.obtainTypedArray(R.array.int_array);
        TypedArray typedFloatArray = resources.obtainTypedArray(R.array.float_array);

        @SuppressLint("ResourceType")
        String textViewString = typedStringArray.getString(0) + ", " +
                typedStringArray.getString(1) + ", " + typedStringArray.getString(2);

        @SuppressLint("ResourceType")
        String textViewIntArrayString = typedIntArray.getInt(0, 0) + ", " +
                typedIntArray.getInt(1, 0) + ", " + typedIntArray.getInt(2, 0);

        @SuppressLint("ResourceType")
        String textViewFloatArrayString = typedFloatArray.getFloat(0, 0) + ", " +
                typedFloatArray.getFloat(1, 0) + ", " + typedFloatArray.getFloat(2, 0);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(textViewFloatArrayString);
    }
}
