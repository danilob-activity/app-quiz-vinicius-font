package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.londonappbrewery.quizzler.models.TrueFalse;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:

    Button mTrueButton;
    Button mFalseButton;
    TextView mScoreTextView;
    TextView mQuestionTextView;
    ProgressBar mProgressBar;

    int mIndex; //armazena a pergunta corrente
    int mScore; //armazena a quantidade de respostas corretas
    int mQuestion; //recebe o id da pergunta corrente

     //TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mScoreTextView = findViewById(R.id.score);
        mQuestionTextView = findViewById(R.id.question_text_view);
        mProgressBar = findViewById(R.id.progress_bar);

        //valores iniciais
        int mIndex = 0;
        int mScore = 0;
        int mQuestion = mQuestionBank[mIndex].getQuestionID();
        mScoreTextView.setText("Score: " + mScore + "/" + mQuestionBank.length);

        Log.d("QuizOut", "Id="+mQuestion);

        mTrueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"True", Toast.LENGTH_LONG).show();
                checkAnswer(true);
                updateQuestion();

            }
        });
    }

    public void clickFalse(View view) {
        Toast.makeText(getApplicationContext(), "False",Toast.LENGTH_SHORT).show();

    }

    public void checkAnswer(boolean b) {
        if(b == mQuestionBank[mIndex].isAnswer()){
            mScore++;
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_LONG).show();
        }
    }

    public void updateQuestion() {

    }
}
