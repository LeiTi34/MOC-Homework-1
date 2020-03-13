package com.example.mochomework1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText firstEdit, secondEdit;
    private Button calcButton, navButton;
    private TextView resultText, seekBarOut;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstEdit = (EditText) findViewById(R.id.first_edit);
        secondEdit = (EditText) findViewById(R.id.second_edit);

        calcButton = (Button) findViewById(R.id.calc_button);
        navButton = (Button) findViewById(R.id.navigate_button);

        resultText = (TextView) findViewById(R.id.result_text);

        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        seekBarOut = (TextView) findViewById(R.id.seek_bar_out);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText(ParseAndCalculate(
                        firstEdit.getText().toString(),
                        secondEdit.getText().toString()));
            }
        });

        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChildActivity.class);

                intent.putExtra(Intent.EXTRA_TEXT, ParseAndCalculate(
                        firstEdit.getText().toString(),
                        secondEdit.getText().toString()));

                startActivity(intent);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarOut.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private String ParseAndCalculate(String firstNbrStr, String secondNbrStr)
    {
        int firstNbr, secondNbr;

        try {
            firstNbr = Integer.parseInt(firstNbrStr);
        } catch (NumberFormatException e) {
            firstNbr = 0;
        }

        try {
            secondNbr = Integer.parseInt(secondNbrStr);
        } catch (NumberFormatException e) {
            secondNbr = 0;
        }

        return String.valueOf(firstNbr + secondNbr);
    }
}
