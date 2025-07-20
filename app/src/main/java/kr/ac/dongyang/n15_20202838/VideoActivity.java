package kr.ac.dongyang.n15_20202838;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

   /*사용할 변수 선언*/
    VideoView vi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        /*findViewById*/
        vi = findViewById(R.id.videoView);

        /*MediaController객체를 만들고, vi에 지정*/
        vi.setMediaController(new MediaController(this));

        /*영상의 경로 설정*/
        /* https://www.youtube.com/watch?v=RRinIPXHNBc */
        vi.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.distancing));
        //setVideoURI : 비디오가 저장되어 있는 경로를 설정
        //getPackageName() : 패키지 이름을 얻어온다

        vi.start();
        //비디오를 재생합니다.

        /*비디오의 재생이 종료되었을때의 동작을 지정*/
        vi.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { //구현과 동시에 등록
            @Override
            public void onCompletion(MediaPlayer mp) {
                vi.start(); //재생
            }
        });
        //영상의 재생이 종료되면 다시 start()메소드가 호출되면서 반복재생 가능
    }

    /*다시 Distancing Activity로 이동하도록 하는 OnClick 메소드 작성*/
    public void goDistancing(View view) {
        finish();
    }
}