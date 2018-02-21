package com.example.android.quiz;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    int score = 0;
    public EditText editText;
    public RadioGroup groupOne, groupTwo;
    public RadioButton rb1, rb2, rb3, rb4, rb6, rb5;
    boolean RadioButtom1, RadioButtom2, RadioButtom3, RadioButtom4, RadioButtom5, RadioButtom6, ischeck_6, ischeck_5, ischeck_4, ischeck_3, ischeck_2, ischeck_1;
    public final String CORRECT_ANSWER = "JAVA";
    public CheckBox checkboxOne, checkboxTwo, checkboxThree, checkboxForth, checkboxFive, checkboxSix;
    int wrong = 0;
    public Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb1 = (RadioButton) findViewById(R.id.choice1);
        //RadioButtom1 = rb1.isChecked();
        rb2 = (RadioButton) findViewById(R.id.choice2);
        // RadioButtom2 = rb2.isChecked();
        rb3 = (RadioButton) findViewById(R.id.choice3);
        //RadioButtom3 = rb3.isChecked();
        checkboxOne = (CheckBox) findViewById(R.id.check_1);
        ischeck_1 = checkboxOne.isChecked();
        checkboxTwo = (CheckBox) findViewById(R.id.check_2);
        ischeck_2 = checkboxTwo.isChecked();
        checkboxThree = (CheckBox) findViewById(R.id.check_3);
        ischeck_3 = checkboxThree.isChecked();
        // score = calculateScore_chechbox1(ischeck_1, ischeck_2, ischeck_3);
        checkboxForth = (CheckBox) findViewById(R.id.check_4);
        ischeck_4 = checkboxForth.isChecked();
        checkboxFive = (CheckBox) findViewById(R.id.check_5);
        ischeck_5 = checkboxFive.isChecked();
        checkboxSix = (CheckBox) findViewById(R.id.check_6);
        ischeck_6 = checkboxSix.isChecked();

        rb4 = (RadioButton) findViewById(R.id.radio_1);
        RadioButtom4 = rb4.isChecked();
        rb5 = (RadioButton) findViewById(R.id.radio_2);
        RadioButtom5 = rb5.isChecked();
        rb6 = (RadioButton) findViewById(R.id.radio_3);
        RadioButtom6 = rb6.isChecked();
        editText = (EditText) findViewById(R.id.name_field);

        groupOne = (RadioGroup) findViewById(R.id.questionGroupOne);
        groupOne.setOnCheckedChangeListener(this);
        groupTwo = (RadioGroup) findViewById(R.id.questionGroupTwo);
        groupTwo.setOnCheckedChangeListener(this);
//        btnSubmit=(Button)findViewById(R.id.mainsubmitBotton);
//        btnSubmit.setOnClickListener(this);
    }


     public void submitOrder(View v) {


    //        RadioButton rb1 = (RadioButton) findViewById(R.id.choice1);
//        boolean RadioButtom1 = rb1.isChecked();
//        RadioButton rb2 = (RadioButton) findViewById(R.id.choice2);
//        boolean RadioButtom2 = rb2.isChecked();
//        RadioButton rb3 = (RadioButton) findViewById(R.id.choice3);
//        boolean RadioButtom3 = rb3.isChecked();
//       score = calculateScore(RadioButtom1, RadioButtom2, RadioButtom3);
//        CheckBox checkboxOne = (CheckBox) findViewById(R.id.check_1);
//        boolean ischeck_1 = checkboxOne.isChecked();
//        CheckBox checkboxTwo = (CheckBox) findViewById(R.id.check_2);
//        boolean ischeck_2 = checkboxTwo.isChecked();
//        CheckBox checkboxThree = (CheckBox) findViewById(R.id.check_3);
//        boolean ischeck_3 = checkboxThree.isChecked();
//        score = calculateScore_chechbox1(ischeck_1, ischeck_2, ischeck_3);
//        CheckBox checkboxForth = (CheckBox) findViewById(R.id.check_4);
//        boolean ischeck_4 = checkboxForth.isChecked();
//        CheckBox checkboxFive = (CheckBox) findViewById(R.id.check_5);
//        boolean ischeck_5 = checkboxFive.isChecked();
//        CheckBox checkboxSix = (CheckBox) findViewById(R.id.check_6);
//        boolean ischeck_6 = checkboxSix.isChecked();
//        score = calculateScore_chechbox2(ischeck_4, ischeck_5, ischeck_6);
//        RadioButton rb4 = (RadioButton) findViewById(R.id.radio_1);
//        boolean RadioButtom4 = rb4.isChecked();
//        RadioButton rb5 = (RadioButton) findViewById(R.id.radio_2);
//        boolean RadioButtom5 = rb5.isChecked();
//        RadioButton rb6 = (RadioButton) findViewById(R.id.radio_3);
//        boolean RadioButtom6 = rb6.isChecked();
    //score = calculateScore2(RadioButtom4, RadioButtom5, RadioButtom6);
//        String nameFromField=editText.getText().toString().trim();
//        if(nameFromField.length()>0 && nameFromField.toUpperCase().equals(CORRECT_ANSWER)){
//            score++;
//            editText.setVisibility(View.INVISIBLE);
//        }
        display(score);
//    }
//        private int calculateScore(boolean RadioButtom1, boolean RadioButtom2, boolean RadioButtom3) {
//        if (RadioButtom1&&!RadioButtom2&&!RadioButtom3 ) {
//            score=0;
//            score = score + 1;
//        }else if (RadioButtom2 ||RadioButtom3)
//            score=0;
//            return score;
//      }
//    private int calculateScore2(boolean RadioButtom4, boolean RadioButtom5, boolean RadioButtom6) {
//        if (!RadioButtom4 && RadioButtom5 && !RadioButtom6  ) {
//            score = score + 1;
//        }
//        return score;
  }
    private void display(int numbers) {
        TextView quantityTextView = (TextView) findViewById(R.id.score);
        quantityTextView.setText("" + numbers);
        String message = "You scored " + score;
        message += " out of 4";
        message += "\nWell done!";
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public int calculateScore_chechbox1(boolean checkOne, boolean checkTwo, boolean checkThree) {
        if (checkOne &&
                checkTwo &&
                !checkThree
                ) {
            score = score + 1;
        }
        return score;
    }

    public int calculateScore_chechbox2(boolean checkFour, boolean checkFive, boolean checkSix) {
        if (!checkFour && checkFive && checkSix) {
            score = score + 1;
        }
        return score;
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {

        int RadioButtonCheck = groupOne.getCheckedRadioButtonId();
        switch (RadioButtonCheck) {
            case R.id.choice1:
                score++;
                disableGroup();
                break;
            case R.id.choice2:
                wrong++;
                disableGroup();
                break;
            case R.id.choice3:
                wrong++;
                disableGroup();
                break;
            default:
                break;
        }
        int RadioButtonCheck2 = groupTwo.getCheckedRadioButtonId();
        switch (RadioButtonCheck2) {

            case R.id.radio_1:
                wrong++;
                disableGroup_2();
                break;
            case R.id.radio_2:
                score++;
                disableGroup_2();
                break;
            case R.id.radio_3:
                wrong++;
                disableGroup_2();
                break;
            default:
                break;
        }
    }

    private void disableGroup() {
        rb1.setEnabled(false);
        rb2.setEnabled(false);
        rb3.setEnabled(false);
    }

    private void disableGroup_2() {
        rb4.setEnabled(false);
        rb5.setEnabled(false);
        rb6.setEnabled(false);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mainsubmitBotton:
                checkEditText();
                break;
        }
    }

    private void checkEditText() {

        String userInputText = editText.getText().toString().trim();

        if (userInputText.length() > 0 && userInputText.equals("JAVA")) {
            score++;
        } else {
            wrong++;
            display(score);
        }
    }

    public void onCheckboxClicked(View view) {
// Is the view now checked?
        if (ischeck_1 && ischeck_2 && !ischeck_3) {
            // Check which checkbox was clicked
            score++;
        }
            else
                wrong++;


    }
}

  // I'm lactose intolerant




//        if (userInputText.length() > 0 && Integer.parseInt(userInputText) == 1){
//            score++;
//        }else{
//            wrong++;
//        }



