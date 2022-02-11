package com.example.fac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.fac.Model.Answer;
import com.example.fac.Model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TracnghiemActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_question;
    private TextView tv_content_question;
    private TextView tv_answer1,tv_answer2,tv_answer3,tv_answer4;
    private List<Question> questionList;
    private Question mQuestion;
    private int currentQuestion = 0;
    private int cau = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracnghiem);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        AnhXa();
        questionList = getListQuestion();
        if(questionList.isEmpty())
        {
            return;
        }
        Random random1 = new Random();
        Cursor cursor = MainActivity.database.Getdata("SELECT CAUHOI FROM DAPAN ORDER BY CAUHOI DESC");
        cursor.moveToNext();
        int val = random1.nextInt(cursor.getInt(0) - 1);
        currentQuestion=val;
        setDataQuestion(questionList.get(currentQuestion));
    }
    private void setDataQuestion(Question question) {
        if(question == null){
            return;
        }
        mQuestion = question;
        tv_answer1.setBackgroundResource(R.drawable.custom_cau);
        tv_answer2.setBackgroundResource(R.drawable.custom_cau);
        tv_answer3.setBackgroundResource(R.drawable.custom_cau);
        tv_answer4.setBackgroundResource(R.drawable.custom_cau);


        String titleQuestion = "Câu Hỏi " + cau;
        tv_question.setText(titleQuestion);
        tv_content_question.setText(question.getContent());
        tv_answer1.setText(question.getAnswerList().get(0).getContent());
        tv_answer2.setText(question.getAnswerList().get(1).getContent());
        tv_answer3.setText(question.getAnswerList().get(2).getContent());
        tv_answer4.setText(question.getAnswerList().get(3).getContent());

    }

    private void AnhXa() {
        tv_question = findViewById(R.id.tv_question);
        tv_content_question = findViewById(R.id.tv_content_question);
        tv_answer1 = findViewById(R.id.tv_answer1);
        tv_answer2 = findViewById(R.id.tv_answer2);
        tv_answer3 = findViewById(R.id.tv_answer3);
        tv_answer4 = findViewById(R.id.tv_answer4);

        tv_answer1.setOnClickListener(this);
        tv_answer2.setOnClickListener(this);
        tv_answer3.setOnClickListener(this);
        tv_answer4.setOnClickListener(this);
    }
    private List<Question> getListQuestion(){
        List<Question> list = new ArrayList<>();
        Cursor cursor =MainActivity.database.Getdata("SELECT CAUHOI FROM DAPAN ORDER BY CAUHOI DESC");
        cursor.moveToNext();
        for(int i =1; i <= cursor.getInt(0);i++){
            List<Answer> answerList1 = new ArrayList<>();
            Cursor cursor1 = MainActivity.database.Getdata("SELECT * FROM DAPAN WHERE CAUHOI = " + i );
            Cursor cursor2 = MainActivity.database.Getdata("SELECT * FROM CAUHOI WHERE IDCH = " + i);
            while (cursor1.moveToNext())
            {
                answerList1.add(new Answer(
                        cursor1.getString(1),
                        Boolean.valueOf(cursor1.getString(3))
                ));
            }
            while (cursor2.moveToNext()){
                list.add(new Question(
                        cursor2.getString(1),answerList1));
            }

        }

//        List<Answer> answerList1 = new ArrayList<>();
//        answerList1.add(new Answer("Gà",true));
//        answerList1.add(new Answer("Cá",false));
//        answerList1.add(new Answer("Bò",false));
//        answerList1.add(new Answer("Lợn",false));
//
//        List<Answer> answerList2 = new ArrayList<>();
//        answerList2.add(new Answer("Gà",true));
//        answerList2.add(new Answer("Cá",false));
//        answerList2.add(new Answer("Bò",false));
//        answerList2.add(new Answer("Lợn",false));
//
//        List<Answer> answerList3 = new ArrayList<>();
//        answerList3.add(new Answer("Gà",true));
//        answerList3.add(new Answer("Cá",false));
//        answerList3.add(new Answer("Bò",false));
//        answerList3.add(new Answer("Lợn",false));
//        list.add(new Question("Tran trong phussssssssssssssssssssssssssssssssssssssssss",1,answerList1));
//        list.add(new Question("Tran123213 trong phu",2,answerList2));
//        list.add(new Question("Tran5465464 trong phu",3,answerList3));
        return list;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_answer1:
                tv_answer1.setBackgroundResource(R.drawable.custom_cautraloi_chon);
                checkAnswer(tv_answer1,mQuestion,mQuestion.getAnswerList().get(0));
                break;
            case R.id.tv_answer2:
                tv_answer2.setBackgroundResource(R.drawable.custom_cautraloi_chon);
                checkAnswer(tv_answer2,mQuestion,mQuestion.getAnswerList().get(1));
                break;
            case R.id.tv_answer3:
                tv_answer3.setBackgroundResource(R.drawable.custom_cautraloi_chon);
                checkAnswer(tv_answer3,mQuestion,mQuestion.getAnswerList().get(2));

                break;
            case R.id.tv_answer4:
                tv_answer4.setBackgroundResource(R.drawable.custom_cautraloi_chon);
                checkAnswer(tv_answer4,mQuestion,mQuestion.getAnswerList().get(3));

                break;
        }
    }
    private void checkAnswer(TextView textView,Question question,Answer answer){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(answer.isCorrect()){
                    textView.setBackgroundResource(R.drawable.custom_cautraloi_dung);
                    nextQuestion();
                }else {
                    textView.setBackgroundResource(R.drawable.custom_cautraloi_sai);
                    showAnswerCorrect(questionList.get(currentQuestion));
                    gameOver();

                }
            }
        },1000);
    }

    private void gameOver() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialog("gameover");

            }
        },1000);
    }

    private void showAnswerCorrect(Question question) {
        if(question==null || question.getAnswerList() == null || question.getAnswerList().isEmpty()){
            return;
        }
        if(question.getAnswerList().get(0).isCorrect()){
            tv_answer1.setBackgroundResource(R.drawable.custom_cautraloi_dung);
        }else if(question.getAnswerList().get(1).isCorrect()){
            tv_answer2.setBackgroundResource(R.drawable.custom_cautraloi_dung);
        }else if(question.getAnswerList().get(2).isCorrect()){
            tv_answer3.setBackgroundResource(R.drawable.custom_cautraloi_dung);
        }else {
            tv_answer4.setBackgroundResource(R.drawable.custom_cautraloi_dung);
        }
    }

    private void nextQuestion() {
//        if(currentQuestion == questionList.size() - 1){
//            showDialog(
//                    "You win"
//            );
        if(cau >= 10){
            showDialog(
                    "You win"
            );
        }else {
            Random random1 = new Random();
            Cursor cursor = MainActivity.database.Getdata("SELECT CAUHOI FROM DAPAN ORDER BY CAUHOI DESC");
            cursor.moveToNext();
            int val = random1.nextInt(cursor.getInt(0) - 1);
            currentQuestion = val;
            cau++;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    setDataQuestion(questionList.get(currentQuestion));

                }
            },1000);

        }

    }
    private void showDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                cau=1;
//                Random random1 = new Random();
//                Cursor cursor = MainActivity.database.Getdata("SELECT CAUHOI FROM DAPAN ORDER BY CAUHOI DESC");
//                cursor.moveToNext();
//                int val = random1.nextInt(cursor.getInt(0) - 1);
//                currentQuestion=val;
//                setDataQuestion(questionList.get(currentQuestion));
                dialogInterface.dismiss();

                startActivity(new Intent(TracnghiemActivity.this,ChoiNgayActivity.class));
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}