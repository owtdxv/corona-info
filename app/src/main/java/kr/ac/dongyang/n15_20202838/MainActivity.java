package kr.ac.dongyang.n15_20202838;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    /*사용할 변수를 선언*/
    EditText print_d_day;
    TextView tv_distancing,tv_covid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*findViewById*/
        print_d_day = findViewById(R.id.editText_date);
        tv_distancing = findViewById(R.id.textView_distancing);
        tv_covid = findViewById(R.id.textView_Covid);

        /* 날짜(D+n일)을 계산*/
        /* https://jamesdreaming.tistory.com/116 의 글 + 객체지향프로그래밍 강의 교재 를 참고함 */
        //Calendar클래스 사용
        Calendar today = Calendar.getInstance();
        Calendar start_day = Calendar.getInstance();
        //getInstance() : 현재 시간을 반환

        //최초 보고일(start_day)은 WHO공식 보고일을 기준으로 합니다(12월 31일)
        start_day.set(2019, Calendar.DECEMBER, 31);

        long l_day = (today.getTimeInMillis() / (24*60*60*1000))  - (start_day.getTimeInMillis() / (24*60*60*1000));
        //밀리 초 단위를 Day(일) 단위로 변환해야 하므로 밀리초 / 24(시) * 60(분) * 60(초) * 1000(밀리초) 로 계산한다.
        //getTimeInMillis() : 시간 정보를 밀리초 단위로 변환

        print_d_day.setText("D+" + String.valueOf(l_day));
        //setText() : textView의 내용을 설정함


        /*Distancing Activity로 이동하도록 하는 OnClickListener구현*/
        tv_distancing.setOnClickListener(new View.OnClickListener() { //구현과 동시에 등록 수행
            @Override
            public void onClick(View v) { //v = 클릭한거
                Intent intent = new Intent(getApplicationContext(), DistancingActivity.class);
                //명시적 Intent 사용(응답x), 목적지를 DistancingActivity.class로 지정
                startActivity(intent);
                //intent에 설정되어 있는 Activity를 열어줌
            }
        });

        /*CoronaActivity로 이동하도록 하는 OnClickListener구현*/
        View.OnClickListener co = new OnClickListener() { //구현을 한 이후, 등록
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CoronaActivity.class);
                //명시적 intent사용(응답x)
                startActivity(intent);
            }
        };
        tv_covid.setOnClickListener(co); //co라는 이름으로 만든 OnClickListener를 tv_covid에 등록
    }

    /*corona-live 웹 페이지로 이동하도록 하는 OnClick 메소드 작성*/
    public void live(View view) { //view = 클릭한거
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://corona-live.com/"));
        //암시적 intent사용
        //Uri.parse("") : 주소를 지정
        startActivity(intent);
    }


    /*질병관리청 홈페이지로 이동하도록 한느 OnClick 메소드 작성*/
    public void korea(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kdca.go.kr/"));
        //암시적 intent사용
        startActivity(intent);
    }
}