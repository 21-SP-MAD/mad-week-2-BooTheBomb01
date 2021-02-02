package edu.lewisu.cs.spreitzermatt.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;

    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;

    private final Question[] mQuestions = new Question[]{
            new Question(R.string.Question_text1, true),
            new Question(R.string.Question_text2, false),
            new Question(R.string.Question_text3, true)
    };

    private int mCurrentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new TrueButtonClickListener());
        
        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new FalseButtonClickListener());
        
        mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new NextButtonClickListener());

        mPrevButton = findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new NextButtonClickListener());
        mQuestionTextView = findViewById(R.id.question_text_view);
        updateQuestion();
        //mNextButton.setOnClickListener(new NextButtonClickListener());
    }

    private void updateQuestion(){
        int question = mQuestions[mCurrentIndex].getTextResID();
        mQuestionTextView.setText(question);

    }

    private void checkAnswer (boolean userPress) {
        boolean correctAnswer = mQuestions[mCurrentIndex].isAnswer();

        int toastTextId;

        if(userPress == correctAnswer){
            toastTextId = R.string.correct;
        } else {
            toastTextId = R.string.incorrect;
        }
        Toast.makeText(getApplicationContext(), toastTextId, Toast.LENGTH_SHORT).show();
    }

    private class TrueButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            checkAnswer(true);
        }
    }
    private class FalseButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            checkAnswer(false);
        }
    }

    private class PrevButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mCurrentIndex = mCurrentIndex - 1;
            if (mCurrentIndex <= 0){
                mCurrentIndex = mQuestions.length-1;
            }
            updateQuestion();
        }
    }
    private class NextButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            mCurrentIndex = mCurrentIndex + 1;
            if (mCurrentIndex >= mQuestions.length){
                mCurrentIndex = 0;
            }
            updateQuestion();
        }
    }
}