package com.example.food8.condi_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SelectActivity extends AppCompatActivity {

    RadioGroup answer1,answer2,answer3;
    LinearLayout content1,content2,content3;
    boolean[] array = new boolean[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        answer1 = (RadioGroup) findViewById(R.id.answer_1);
        answer2 = (RadioGroup) findViewById(R.id.answer_2);
        answer3 = (RadioGroup) findViewById(R.id.answer_3);

        content1 = (LinearLayout) findViewById(R.id.linearLayout);
        content2 = (LinearLayout) findViewById(R.id.linearLayout2);
        content3 = (LinearLayout) findViewById(R.id.linearLayout3);


        answer1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                content2.setVisibility(View.VISIBLE);
                if(checkedId==R.id.radio1_yes){
                    findViewById(checkedId).setBackgroundDrawable(getResources().getDrawable(R.drawable.yes_one_select));
                    findViewById(R.id.radio1_no).setBackgroundDrawable(getResources().getDrawable(R.drawable.no_one));
                }else if(checkedId==R.id.radio1_no){
                    findViewById(checkedId).setBackgroundDrawable(getResources().getDrawable(R.drawable.no_one_select));
                    findViewById(R.id.radio1_yes).setBackgroundDrawable(getResources().getDrawable(R.drawable.yes_one));
                }
            }
        });

        answer2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                content3.setVisibility(View.VISIBLE);
                if(checkedId==R.id.radio2_yes){
                    findViewById(checkedId).setBackgroundDrawable(getResources().getDrawable(R.drawable.yes_one_select));
                    findViewById(R.id.radio2_no).setBackgroundDrawable(getResources().getDrawable(R.drawable.no_one));
                }else if(checkedId==R.id.radio2_no){
                    findViewById(checkedId).setBackgroundDrawable(getResources().getDrawable(R.drawable.no_one_select));
                    findViewById(R.id.radio2_yes).setBackgroundDrawable(getResources().getDrawable(R.drawable.yes_one));
                }
            }
        });

        answer3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId==R.id.radio3_yes){
                    findViewById(checkedId).setBackgroundDrawable(getResources().getDrawable(R.drawable.yes_one_select));
                    findViewById(R.id.radio3_no).setBackgroundDrawable(getResources().getDrawable(R.drawable.no_one));
                }else if(checkedId==R.id.radio3_no){
                    findViewById(checkedId).setBackgroundDrawable(getResources().getDrawable(R.drawable.no_one_select));
                    findViewById(R.id.radio3_yes).setBackgroundDrawable(getResources().getDrawable(R.drawable.yes_one));
                }
                RadioButton rd1 = (RadioButton) findViewById(answer1.getCheckedRadioButtonId());
                RadioButton rd2 = (RadioButton) findViewById(answer2.getCheckedRadioButtonId());
                RadioButton rd3 = (RadioButton) findViewById(answer3.getCheckedRadioButtonId());
                if(rd1.getId()==R.id.radio1_yes){
                    array[0] = true;
                }else if(rd1.getId()==R.id.radio1_no){
                    array[0] = false;
                }
                if(rd2.getId()==R.id.radio2_yes){
                    array[1] = true;
                }else if(rd2.getId()==R.id.radio2_no){
                    array[1] = false;
                }
                if(rd3.getId()==R.id.radio3_yes){
                    array[2] = true;
                }else if(rd3.getId()==R.id.radio3_no){
                    array[2] = false;
                }
                if(!array[0]&&!array[1]&&!array[2]){
                    Toast.makeText(getApplicationContext(),"적어도 하나의 기분은 선택을 하셔야 합니다.",Toast.LENGTH_LONG).show();
                }else if(array[0]&&array[1]&&array[2]){
                    Toast.makeText(getApplicationContext(),"슬프면서 기쁘면서 화날순 없습니다.",Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                    intent.putExtra("array", array);
                    startActivity(intent);
                }
            }
        });

    }
}
