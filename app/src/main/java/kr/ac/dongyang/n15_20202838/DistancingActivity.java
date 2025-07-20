package kr.ac.dongyang.n15_20202838;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DistancingActivity extends AppCompatActivity {

    /*사용할 변수 선언*/
    TextView phase_title;
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
    RadioGroup rgPhase;
    Button btn_dis;

    /*어느 Activity로 부터 응답을 받는지를 구분하기위해 사용하는 값.*/
    final static int REQUEST_CHECK = 100;

    /*선택된 라디오 버튼의 값을 구분하여 StateActivity에서 사용하기 위한 변수*/
    int radio_code=1;
    //선택한 RadioButton 에 따라 1~5까지로 구분
    //checked:true로 설정된 값(디폴트값)이 rgbtn1이므로 초기값도 1로 지정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distancing);

        /*findViewById*/
        phase_title = findViewById(R.id.textView_Phase_title);
        textView1 = findViewById(R.id.textView1_); textView2 = findViewById(R.id.textView2_); textView3 = findViewById(R.id.textView3_);
        textView4 = findViewById(R.id.textView4_); textView5 = findViewById(R.id.textView5_); textView6 = findViewById(R.id.textView6_);
        textView7 = findViewById(R.id.textView7_);
        rgPhase = findViewById(R.id.rg_phase);
        btn_dis = findViewById(R.id.btn1);

        /*radio버튼의 체크 상태가 변경되었을 때의 동작을 지정*/
        rgPhase.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { //구현과 동시에 등록
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) { //group : RadioGroup, checkedId : 체크한 RadioButton의 id값
                switch (checkedId) {
                    case R.id.rgbtn1 :
                        radio_code = 1;
                        //StateActivity로 전송할 값(radio_code)을 설정

                        phase_title.setText("생활 방역");
                        phase_title.setBackgroundColor(Color.rgb(255,204,204));
                        //.setBackgroundColor : '배경'의 색상을 지정 (객체지향프로그래밍 강의에서 배운 내용)
                        //Color.rgb : 색상을 rgb값을 사용해 지정

                        textView1.setText(R.string.mask_1); textView2.setText(R.string.party_1); textView3.setText(R.string.sport_1);
                        textView4.setText(R.string.bus_1_1_5); textView5.setText(R.string.school_1); textView6.setText(R.string.holy_1);
                        textView7.setText(R.string.com_1);
                        break;
                    case R.id.rgbtn1_5 :
                        radio_code = 2;
                        phase_title.setText("지역적 유행 단계");
                        phase_title.setBackgroundColor(Color.rgb(255,153,153));
                        textView1.setText(R.string.mask_1_5); textView2.setText(R.string.party_1_5); textView3.setText(R.string.sport_1_5);
                        textView4.setText(R.string.bus_1_1_5); textView5.setText(R.string.school_1_5); textView6.setText(R.string.holy_1_5);
                        textView7.setText(R.string.com_1_5_2);
                        break;
                    case R.id.rgbtn2 :
                        radio_code = 3;
                        phase_title.setText("지역적 유행 단계");
                        phase_title.setBackgroundColor(Color.rgb(255,102,102));
                        textView1.setText(R.string.mask_2); textView2.setText(R.string.party_2); textView3.setText(R.string.sport_2);
                        textView4.setText(R.string.bus_2); textView5.setText(R.string.school_2); textView6.setText(R.string.holy_2);
                        textView7.setText(R.string.com_1_5_2);
                        break;
                    case R.id.rgbtn2_5 :
                        radio_code = 4;
                        phase_title.setText("전국적 유행 단계");
                        phase_title.setBackgroundColor(Color.rgb(255,51,51));
                        textView1.setText(R.string.mask_2_5_3); textView2.setText(R.string.party_2_5); textView3.setText(R.string.sport_2_5);
                        textView4.setText(R.string.bus_2_5); textView5.setText(R.string.school_2_5); textView6.setText(R.string.holy_2_5);
                        textView7.setText(R.string.com_2_5);
                        break;
                    case R.id.rgbtn3 :
                        radio_code = 5;
                        phase_title.setText("전국적 유행 단계");
                        phase_title.setBackgroundColor(Color.rgb(255,0,0));
                        textView1.setText(R.string.mask_2_5_3); textView2.setText(R.string.party_3); textView3.setText(R.string.sport_3);
                        textView4.setText(R.string.bus_3); textView5.setText(R.string.school_3); textView6.setText(R.string.holy_3);
                        textView7.setText(R.string.com_3);
                        break;
                }
            }
        });

        /*State Activity로 이동하도록 하는 OnClickListener 구현*/
        btn_dis.setOnClickListener(new View.OnClickListener() { //구현과 동시에 등록
            @Override
            public void onClick(View v) {
                Intent intentD = new Intent(getApplicationContext(), StateActivity.class);
                //명시적 intent사용(응답o)
                intentD.putExtra("rdCode", radio_code);
                //putExtra : 만든 intent에 다른 Activity로 전송할 값을 저장
                //putExtra(name, value) : name = 구분하기위한 이름, value = 전송할 값
                startActivityForResult(intentD, REQUEST_CHECK);
                //startActivityForResult : 새로운 Activity를 열어주면서 결과값(REQUEST_CHECK)도 전송
            }
        });
    }

    /*video Activity로 이동하도록 하는 OnClick메소드 작성*/
    public void video(View view) {
        Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
        //명시적 intent를 사용(응답x)
        startActivity(intent);
    }

    /*Main Activity로 이동하도록 하는 OnClick 메소드 작성*/
    public void goMain(View view) {
        finish();
    }
}