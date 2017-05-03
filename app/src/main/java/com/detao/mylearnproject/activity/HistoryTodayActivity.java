package com.detao.mylearnproject.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bolex.pressscan.ScanTools;
import com.bumptech.glide.Glide;
import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;
import com.detao.mylearnproject.bean.UserInfo;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.http.GET;

import static com.detao.mylearnproject.util.AppUtils.webViewTest;

/**
 * Created by shaoronggang on 2017/4/14.
 */

public class HistoryTodayActivity extends BaseActivity {


    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.iv_scan_image)
    ImageView ivScanImage;
    @BindView(R.id.iv_scan_text)
    ImageView ivScanText;
    @BindView(R.id.iv_after_scan)
    ImageView ivAfterScan;
    @BindView(R.id.web_test)
    WebView webTest;
    @BindView(R.id.tv_scan_text)
    TextView tvScanText;

    @Override
    protected int getResLayout() {
        return R.layout.history_today_activity;
    }

    @Override
    public void afterView() {
        super.afterView();
        webViewTest(url,webTest);

        ivScan.setImageResource(R.drawable.scan_weburl); //设置网址显示的扫描
        ivScanImage.setImageResource(R.drawable.scan_image_url); //设置图片网址的扫描
        ivScanText.setImageResource(R.drawable.scan_text); //设置文本显示的二维码，注意：如果文字过多时，会以网页的的形式出现
        scanView(ivScan);
        scanView(ivScanImage);
        scanView(ivScanText);
    }

    public interface GithubClient{
        @GET("/user/info")
        Call<UserInfo> getUserInfo();
    }

    private void scanView(View view) {
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ScanTools.scanCode(v, new ScanTools.ScanCall() {
                    @Override
                    public void getCode(String code) {
                        Toast.makeText(HistoryTodayActivity.this, code, Toast.LENGTH_SHORT).show();
                        if (code != null && code.endsWith(".jpg")) {
                            ivAfterScan.setVisibility(View.VISIBLE);
                            Glide.with(HistoryTodayActivity.this).load(code).placeholder(R.drawable.meinv1).into(ivAfterScan);
                        } else if (code.startsWith("http://")) {
                            webViewTest(code,webTest);
                        } else {
                            tvScanText.setText(code);
                        }

                    }
                });
                return true;
            }
        });
    }

    /**
     * 进行webView的相关的Api的测试
     */
    String url = "http://www.baidu.com";

}
