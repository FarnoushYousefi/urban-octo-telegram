package com.example.android.submit_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    String CORRECT_ANSWER = "JAVA";
    EditText nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameField = (EditText) findViewById(R.id.name_field);
    }

    public void submitOrder(View v) {

        RadioButton rb1 = (RadioButton) findViewById(R.id.choice1);
        boolean RadioButtom1 = rb1.isChecked();
        RadioButton rb2 = (RadioButton) findViewById(R.id.choice2);
        boolean RadioButtom2 = rb2.isChecked();
        RadioButton rb3 = (RadioButton) findViewById(R.id.choice3);
        boolean RadioButtom3 = rb3.isChecked();
        score = calculateScore(RadioButtom1, RadioButtom2, RadioButtom3);
        CheckBox checkboxOne = (CheckBox) findViewById(R.id.check_1_questionTwo);
        boolean ischeck_1 = checkboxOne.isChecked();
        CheckBox checkboxTwo = (CheckBox) findViewById(R.id.check_2_questionTwo);
        boolean ischeck_2 = checkboxTwo.isChecked();
        CheckBox checkboxThree = (CheckBox) findViewById(R.id.check_3_questionTwo);
        boolean ischeck_3 = checkboxThree.isChecked();
        score = calculateScore_chechbox1(ischeck_1, ischeck_2, ischeck_3);
        CheckBox checkboxForth = (CheckBox) findViewById(R.id.check_4_questionThree);
        boolean ischeck_4 = checkboxForth.isChecked();
        CheckBox checkboxFive = (CheckBox) findViewById(R.id.check_5_questionThree);
        boolean ischeck_5 = checkboxFive.isChecked();
        CheckBox checkboxSix = (CheckBox) findViewById(R.id.check_6_questionThree);
        boolean ischeck_6 = checkboxSix.isChecked();
        score = calculateScore_chechbox2(ischeck_4, ischeck_5, ischeck_6);
        RadioButton rb4 = (RadioButton) findViewById(R.id.radio_1);
        boolean RadioButtom4 = rb4.isChecked();
        RadioButton rb5 = (RadioButton) findViewById(R.id.radio_2);
        boolean RadioButtom5 = rb5.isChecked();
        RadioButton rb6 = (RadioButton) findViewById(R.id.radio_3);
        boolean RadioButtom6 = rb6.isChecked();
        score = calculateScore2(RadioButtom4, RadioButtom5, RadioButtom6);
        display(score);
    }

    private int calculateScore(boolean RadioButtom1, boolean RadioButtom2, boolean RadioButtom3) {
        if (RadioButtom1 && !RadioButtom2 && !RadioButtom3) {

            score+=1;
        } else if (RadioButtom2 || RadioButtom3) {
            score = 0;
        }
        String userInputText = nameField.getText().toString().trim();
        if (userInputText.length() > 0 && userInputText.equals(CORRECT_ANSWER)) {
            score++;
        }
        return score;
    }

    private int calculateScore2(boolean RadioButtom4, boolean RadioButtom5, boolean RadioButtom6) {
        if (!RadioButtom4 && RadioButtom5 && !RadioButtom6) {
            score+=1;
        }
        return score;
    }

    private void display(int numbers) {
        TextView quantityTextView = (TextView) findViewById(R.id.score);
        quantityTextView.setText("" + numbers);
        String message = "You scored " + score;
        message += " out of 5";
        message += "\nWell done!";
        score = 0;
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public int calculateScore_chechbox1(boolean checkOne, boolean checkTwo, boolean checkThree) {
        if (checkOne &&
                checkTwo &&
                !checkThree
                ) {
            score+=1;
        }
        return score;
    }

    public int calculateScore_chechbox2(boolean checkFour, boolean checkFive, boolean checkSix) {
        if (!checkFour && checkFive && checkSix) {
            score+=1;
        }
        return score;
    }

}
