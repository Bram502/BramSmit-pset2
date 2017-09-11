package com.example.bwhsm.bramsmit_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.startButton).setOnClickListener(new ClickHandler());


    }

    public void goToSelection() {
        Intent i= new Intent(this, SelectionActivity.class);
        startActivity(i);
        finish();
    }

    private class ClickHandler implements View.OnClickListener {
        public void onClick(View arg0) {
            goToSelection();
        }
    }
}
