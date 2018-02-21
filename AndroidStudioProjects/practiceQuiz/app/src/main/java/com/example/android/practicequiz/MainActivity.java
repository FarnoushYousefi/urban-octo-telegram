package com.example.android.practicequiz;

import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//import static android.support.v4.media.session.MediaControllerCompatApi21.TransportControls.play;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        View.OnClickListener , CheckBox.OnCheckedChangeListener {
    /*+=====================================
        Added The CheckBox.OnCheckedChangeListener
=====================================*/

    private RadioGroup groupOne;
    private RadioGroup groupTwo;

    private RadioButton rBtnOne,
            rbtnTwo, rbtnThree, rbtnFour;

    private EditText editText;

    private CheckBox checkBoxOne, checkBoxTwo, checkBoxThree;

    private Button btnSubmit;

    //    Four Question
    int score = 0;
    int wrong = 0;
    final int TotalAnswerCorrect = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groupOne = (RadioGroup)findViewById(R.id.questionGroupOne);
        groupOne.setOnCheckedChangeListener(this);


        rBtnOne = (RadioButton)findViewById(R.id.questionGroupOneChoiceOne);
        rbtnTwo = (RadioButton)findViewById(R.id.questionGroupOneChoiceTwo);

        groupTwo = (RadioGroup)findViewById(R.id.questionGroupTw0);
        groupTwo.setOnCheckedChangeListener(this);

        rbtnThree = (RadioButton)findViewById(R.id.questionGroupTwoChoiceOne);
        rbtnFour = (RadioButton)findViewById(R.id.questionGroupTwoChoiceTwo);

        editText = (EditText)findViewById(R.id.mainEditText);

        btnSubmit = (Button)findViewById(R.id.mainSubmitButton);
        btnSubmit.setOnClickListener(this);

        checkBoxOne = (CheckBox)findViewById(R.id.correctAnswer);
        checkBoxTwo = (CheckBox)findViewById(R.id.secondAnswer);
        checkBoxThree = (CheckBox)findViewById(R.id.thirdAnswer);

        checkBoxOne.setOnCheckedChangeListener(this);
        checkBoxTwo.setOnCheckedChangeListener(this);
        checkBoxThree.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {


        switch(checkedId){
            case R.id.questionGroupOneChoiceOne:
                score++;
                disableGroup();
                break;
            case R.id.questionGroupOneChoiceTwo:
                wrong++;
                disableGroup();
                break;
            case R.id.questionGroupTwoChoiceOne:
                score++;
                disableGroup2();
                break;
            case R.id.questionGroupTwoChoiceTwo:
                wrong++;
                disableGroup2();
                break;
            default:
                break;
        }
    }




    private void disableGroup() {
        rBtnOne.setEnabled(false);
        rbtnTwo.setEnabled(false);

    }
    private void disableGroup2() {
        rbtnFour.setEnabled(false);
        rbtnThree.setEnabled(false);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.mainSubmitButton:
//                We want to check if EditText contain text and if the text matches the correct Answer
                checkEditText();
                break;
        }
    }

    private void checkEditText() {

        String userInputText = editText.getText().toString().trim();

        if (userInputText.length() > 0 && userInputText.equals("1")) {
            score++;
        } else {
            wrong++;
        }
// Check if the correct checkbox is Checked
        if (checkBoxOne.isChecked()){
            score++;
        }else{
            wrong++;
        }

        display(score);
//        If you press enter again the score will go up
//        because the previous if statement was called again
        
    }

        private void display(int numbers) {
           // TextView quantityTextView = (TextView) findViewById(R.id.score);
            //quantityTextView.setText("" + numbers);
            String message = "You scored " + score;
            message += " out of 4";
            message += "\nWell done!";
            Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        /*+=====================================
        Inside this listner I check to see which view is click
        If checkbox 1 is check
        checkbox two and three will uncheck
        if checkbox 2 is check
        checkbox one and three will uncheck
=====================================*/

        switch (buttonView.getId()){
            case R.id.correctAnswer:
                checkBoxThree.setChecked(false);
                checkBoxTwo.setChecked(false);
                break;
            case R.id.secondAnswer:
                checkBoxThree.setChecked(false);
                checkBoxOne.setChecked(false);
                break;
        }
     }

    }

