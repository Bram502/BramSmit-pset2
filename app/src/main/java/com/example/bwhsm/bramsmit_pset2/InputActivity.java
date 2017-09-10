package com.example.bwhsm.bramsmit_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class InputActivity extends AppCompatActivity {

    EditText userInput;
    TextView instructionView;
    TextView count;
    Story currentStory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        currentStory = (Story) getIntent().getSerializableExtra("story");

        findViewById(R.id.enterButton).setOnClickListener(new ClickHandler());

        userInput = (EditText) findViewById(R.id.userInput);
        count = (TextView) findViewById(R.id.count);
        instructionView = (TextView) findViewById(R.id.instruction);


        startInputLoop();
    }

    private void startInputLoop() {
        String nextPlaceholder = currentStory.getNextPlaceholder();
        Int count
        userInput.setText(nextPlaceholder);

        instructionView.setText("Please enter a/an " + nextPlaceholder);
        count.setText("");
    }

    private class ClickHandler implements View.OnClickListener {
        public void onClick(View arg0) {
//            ((TextView)findViewById(R.id.testText)).setText(userInput.getText());
            ((TextView)findViewById(R.id.testText)).setText(currentStory.toString());
            startInputLoop();
        }
    }
}


