package com.example.mochomework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        resultText = (TextView) findViewById(R.id.child_result);

        Intent intent = getIntent();

        if(intent.hasExtra(Intent.EXTRA_TEXT)) {
            resultText.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
        }
    }
}
