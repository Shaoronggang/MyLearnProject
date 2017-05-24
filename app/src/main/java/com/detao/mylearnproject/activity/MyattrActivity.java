package com.detao.mylearnproject.activity;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

/**
 * Created by shaoronggang on 2017/5/19.
 * 本页面集成了相应的语音听写，自定义属性
 *
 */

public class MyattrActivity extends BaseActivity {
    @Override
    protected int getResLayout() {
        return R.layout.myattractivity;
    }

    public void open(View v){
        initIfly(this);
    }

    /**
     * 测试语音听写功能
     * @param context
     */
    private void initIfly(Context context) {
        //创建RecoginizerDialog对象
        RecognizerDialog mDialog = new RecognizerDialog(this,mInitListener);
        //设置accent , language等参数
        mDialog.setParameter(SpeechConstant.LANGUAGE,"zh_cn");
        mDialog.setParameter(SpeechConstant.ACCENT,"mandarin");

        //3.设置回调接口
        mDialog.setListener(new RecognizerDialogListener() {
            @Override
            public void onResult(RecognizerResult recognizerResult, boolean b) {

            }

            @Override
            public void onError(SpeechError speechError) {

            }
        });
        mDialog.show();
    }

    /**
     * 初始化监听器。
     */
    private InitListener mInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            if (code != ErrorCode.SUCCESS) {
                Toast.makeText(MyattrActivity.this, "初始化失败，错误码：" + code, Toast.LENGTH_SHORT).show();
            }
        }
    };

}
