package kr.ac.dongyang.n15_20202838;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class CoronaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corona);
    }

    /*Main Activity로 이동하도록 하는 OnClick 메소드 작성*/
    public void goMain2(View view) {
        finish(); //finish() : 원래의 Activity로 돌아감
        //응답이 필요한경우도 아니고, 다시 전송할 데이터도 없으므로 finish()만 작성
    }
}