package com.detao.youkumenu;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import cafe.adriel.androidaudiorecorder.AndroidAudioRecorder;
import cafe.adriel.androidaudiorecorder.model.AudioChannel;
import cafe.adriel.androidaudiorecorder.model.AudioSampleRate;
import cafe.adriel.androidaudiorecorder.model.AudioSource;

public class MainActivity extends AppCompatActivity {
    private PDFView pdfView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    //初始化视图
    private void init() {
        textView = (TextView) findViewById(R.id.tv_test);
    }


    /**
     * 点击进行相应的录音操作
     * @param view
     */
    public void record(View view){
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recorded_audio.wav";
        int color = getResources().getColor(R.color.colorPrimaryDark);
        int requestCode = 0;

        AndroidAudioRecorder.with(this)
                //Required
                .setFilePath(filePath)
                .setColor(color)
                .setRequestCode(requestCode)

                //Optional
                .setSource(AudioSource.MIC) //麦克风传入资源
                .setChannel(AudioChannel.STEREO) // 声道一般默认是单声道，可以适配所有设备，但是这里设置为立体声
                .setSampleRate(AudioSampleRate.HZ_44100) //取样频率，一般是HZ_44100这个适合所有的设备
                .setAutoStart(false)
                .setKeepDisplayOn(true)
                .record();
    }

    /**
     * 回调函数，可以在这里处理数据，完成相应的上传服务器的操作
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0) {
            if(resultCode == RESULT_OK) {
                
            }else if(resultCode == RESULT_CANCELED) {
                
            }
            
        }
        
        
    }
}
