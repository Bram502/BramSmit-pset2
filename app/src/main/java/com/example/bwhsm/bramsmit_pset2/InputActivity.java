package com.example.bwhsm.bramsmit_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class InputActivity extends AppCompatActivity {

    EditText userInput;
    TextView instructionView;
    TextView countView;
    Story currentStory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        currentStory = (Story) getIntent().getSerializableExtra("story");

        findViewById(R.id.enterButton).setOnClickListener(new ClickHandler());

        userInput = (EditText) findViewById(R.id.userInput);
        countView = (TextView) findViewById(R.id.countView);
        instructionView = (TextView) findViewById(R.id.instructionView);


        startInputLoop();
    }

    private void startInputLoop() {
        String nextPlaceholder = currentStory.getNextPlaceholder();
        int count = currentStory.getPlaceholderRemainingCount();
        userInput.setText("");
        userInput.setHint(nextPlaceholder);
        instructionView.setText("Please enter a/an " + nextPlaceholder);
        countView.setText(count + " word(s) remaining");
    }

    public void goToDisplay() {
        Intent i= new Intent(this, DisplayActivity.class);
        i.putExtra("story", currentStory);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent i= new Intent(this, SelectionActivity.class);
        startActivity(i);
        finish();
    }

    private class ClickHandler implements View.OnClickListener {
        public void onClick(View arg0) {
            String input = userInput.getText().toString();
            currentStory.fillInPlaceholder(input);
            if(currentStory.isFilledIn()) {
                goToDisplay();
            }
            else {
                startInputLoop();
            }
        }
    }
}


