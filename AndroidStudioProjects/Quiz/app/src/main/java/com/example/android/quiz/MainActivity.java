package com.example.android.quiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View v) {
        //require to import the RadioButton class
        RadioButton rb;
        RadioButton rb1 = (RadioButton) findViewById(R.id.choice1);
        boolean RadioButtom1 = rb1.isChecked();
        RadioButton rb2 = (RadioButton) findViewById(R.id.choice2);
        boolean RadioButtom2 = rb2.isChecked();
        RadioButton rb3 = (RadioButton) findViewById(R.id.choice3);
        boolean RadioButtom3 = rb3.isChecked();
        RadioButton rb4 = (RadioButton) findViewById(R.id.choice4);
        boolean RadioButtom4 = rb4.isChecked();
        score = calculateScore(RadioButtom1, RadioButtom2, RadioButtom3, RadioButtom4);

        CheckBox checkboxOne =(CheckBox) findViewById(R.id.check_1);
        boolean ischeck_1 =checkboxOne.isChecked();

        CheckBox checkboxTwo = (CheckBox)findViewById(R.id.check_2);
        boolean ischeck_2 = checkboxTwo.isChecked();

        CheckBox checkboxThree = (CheckBox)findViewById(R.id.check_3);
        boolean ischeck_3 = checkboxThree.isChecked();
        score= calculateScore_chechbox(ischeck_1,ischeck_2);
         display(score);
        //is the current radio button now checked?
        //rb.isChecked();

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.choice1:
                if (checked)
                    Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.choice2:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    private int calculateScore(boolean RadioButtom1, boolean RadioButtom2, boolean RadioButtom3, boolean RadioButtom4) {

        if (RadioButtom1) {
            score = score + 1;
        }
        return score;

    }
    private void display(int numbers) {
        TextView quantityTextView = (TextView) findViewById(R.id.score);
        quantityTextView.setText("" + numbers);

    }

    private int calculateScore_chechbox(boolean checkone, boolean checktwo) {


        if (checkone & checktwo) {
            score = score + 1;
        }

        return score;

    }



    public void choice1 (View view) {
        Toast.makeText(this, "Wrong! well done", Toast.LENGTH_SHORT).show();
    }

    public void choice2 (View view)  {
        Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show();
    }

    public void choice3 (View view)  {
        Toast.makeText(this, "Yes! Well done :)", Toast.LENGTH_SHORT).show();
    }

    public void choice4 (View view)  {
        Toast.makeText(this, "Wrong! Try again", Toast.LENGTH_SHORT).show();
    }


}
