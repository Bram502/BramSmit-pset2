package com.example.bwhsm.bramsmit_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class SelectionActivity extends AppCompatActivity {

    Story currentStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);


        findViewById(R.id.random).setOnClickListener(new ClickHandler());
        findViewById(R.id.option0).setOnClickListener(new ClickHandler());
        findViewById(R.id.option1).setOnClickListener(new ClickHandler());
        findViewById(R.id.option2).setOnClickListener(new ClickHandler());
        findViewById(R.id.option3).setOnClickListener(new ClickHandler());
        findViewById(R.id.option4).setOnClickListener(new ClickHandler());
    }

    private void initializeStory(String file) {
        try {
            InputStream is = getAssets().open(file);
            currentStory = new Story(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeRandomStory() {

        Random rand = new Random();
        int i = rand.nextInt(5);
        System.out.println(i);
        switch (i) {
            case 0:
                initializeStory("madlib0_simple.txt");
                break;
            case 1:
                initializeStory("madlib1_tarzan.txt");
                break;
            case 2:
                initializeStory("madlib2_university.txt");
                break;
            case 3:
                initializeStory("madlib3_clothes.txt");
                break;
            case 4:
                initializeStory("madlib4_dance.txt");
                break;
        }
    }

    public void goToInput() {
        Intent i= new Intent(this, InputActivity.class);
        i.putExtra("story", currentStory);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }


    private class ClickHandler implements View.OnClickListener {
        public void onClick(View arg0) {
            Button btn = (Button) arg0;
            String txt = btn.getText().toString();

            if (txt.equals("Random Story")) {
                initializeRandomStory();
            }
            else {
                switch (txt) {
                    case "Simple Story":
                        initializeStory("madlib0_simple.txt");
                        break;
                    case "Tarzan":
                        initializeStory("madlib1_tarzan.txt");
                        break;
                    case "University":
                        initializeStory("madlib2_university.txt");
                        break;
                    case "Clothes":
                        initializeStory("madlib3_clothes.txt");
                        break;
                    case "Dance":
                        initializeStory("madlib4_dance.txt");
                        break;
                }
            }
            goToInput();
        }
    }



}
