package com.example.bwhsm.bramsmit_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeStory();

    }

    private void initializeStory() {
        Story currentStory = null;
        try {
            InputStream is = getAssets().open("madlib0_simple.txt");
            currentStory = new Story(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(currentStory.toString());
    }

    public void goToFirst(View view) {

//        EditText editText = (EditText) findViewById(R.id.editText);
//        String text = editText.getText().toString();

        Intent intent = new Intent(this, FirstActivity.class);
//        intent.putExtra("word", text);

        startActivity(intent);
        finish();
    }
}
