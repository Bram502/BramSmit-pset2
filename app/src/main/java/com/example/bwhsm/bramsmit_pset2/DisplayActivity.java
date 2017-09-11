package com.example.bwhsm.bramsmit_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    Story currentStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        currentStory = (Story) getIntent().getSerializableExtra("story");
        TextView display = (TextView) findViewById(R.id.display);
        display.setText(currentStory.toString());

    }

    @Override
    public void onBackPressed() {
        Intent i= new Intent(this, SelectionActivity.class);
        startActivity(i);
        finish();
    }
}
