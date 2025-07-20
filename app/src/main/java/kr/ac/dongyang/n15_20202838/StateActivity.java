package kr.ac.dongyang.n15_20202838;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StateActivity extends AppCompatActivity {

    /*사용할 변수 선언*/
    TextView tv_phase_num, tv_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        /*findViewById*/
        tv_phase_num = findViewById(R.id.textView_Phase_num);
        tv_state = findViewById(R.id.textView_state);

        /*Distancing Activity에서 전송한 Intent를 받아옴*/
        Intent intentD = getIntent();
        //getIntent() : 전송된 intent값을 받습니다.

        /*받아온 intent가 null값이 아니라는 전제하에 작성, 이를 위해 if문을 사용*/
        if(intentD != null) {
            int code = intentD.getIntExtra("rdCode",0);
            //전송했던 값의 자료형이 Int이므로 getIntExtra를 통해 값을 받아옴
            //getIntExtra(name, defaultValue)
            //name : Distancing Activity에서 값을 전송할 때 지정했던 이름
            //defaultValue : 받아온 값에 저장되어 있는 값이 없을 때 기본 데이터를 넣어주는 역할을 함, 임의로 작성해도 상관 없음

            /*받아온 rdCode값에 따라 동작을 지정*/
            switch (code) {
                case 1 :
                    tv_phase_num.setText(R.string.num1);
                    tv_phase_num.setBackgroundColor(Color.rgb(255,204,204));
                    tv_state.setText(R.string.none);
                    break;
                case 2 :
                    tv_phase_num.setText(R.string.num1_5);
                    tv_phase_num.setBackgroundColor(Color.rgb(255,153,153));
                    tv_state.setText(R.string.area1_5);
                    break;
                case 3 :
                    tv_phase_num.setText(R.string.num2);
                    tv_phase_num.setBackgroundColor(Color.rgb(255,102,102));
                    tv_state.setText(R.string.area2);
                    break;
                case 4 :
                    tv_phase_num.setText(R.string.num2_5);
                    tv_phase_num.setBackgroundColor(Color.rgb(255,51,51));
                    tv_state.setText(R.string.area2_5);
                    break;
                case 5 :
                    tv_phase_num.setText(R.string.num3);
                    tv_phase_num.setBackgroundColor(Color.rgb(255,0,0));
                    tv_state.setText(R.string.none);
                    break;
            }
        }
    }


    /*Distancing Activity로 이동하도록 하는 Onclick 메소드 작성*/
    public void goDistancing2(View view) {
        setResult(RESULT_OK);
        //setResult : 원래의 activity로 응답을 보냄
        //매개변수로 resultCode와 intent를 사용. 그런데 지금 상황에서는 다시 Distancing Activity로 전송해줘야할 값이 없기 때문에 resultCode만 작성
        //resultCode : RESULT_OK, RESULT_CANCELED, RESULT_FIRST_USER (대문자로 작성)
        finish();
    }
}