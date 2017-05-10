package com.detao.mylearnproject.youkumenu;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static com.detao.mylearnproject.youkumenu.Tools.hideView;
import static com.detao.mylearnproject.youkumenu.Tools.showView;


/**
 * Created by shaoronggang on 2017/5/10.
 */

public class YoukuActivity extends BaseActivity {
    @BindView(R.id.level3)
    RelativeLayout level3;
    @BindView(R.id.level2)
    RelativeLayout level2;
    @BindView(R.id.level1)
    RelativeLayout level1;
    /**
     * 是否显示第三圆环
     */
    private boolean isShowLevel3 = true;
    /**
     * 是否显示第二圆环
     */
    private boolean isShowLevel2 = true;
    /**
     * 是否显示第一圆环
     */
    private boolean isShowLevel1 = true;


    @Override
    protected int getResLayout() {
        return R.layout.youkuactivity;
    }


    @OnClick({R.id.level3, R.id.icon_menu, R.id.level2, R.id.icon_home, R.id.level1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.level3:
                Toast.makeText(YoukuActivity.this, "level3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icon_menu:
                Log.e("State:", isShowLevel2 + ":" + isShowLevel3);

                if (isShowLevel3) {
                    isShowLevel3 = false;
                    hideView(level3);
                } else {
                    isShowLevel3 = true;
                    showView(level3, 200);
                }
                break;
            case R.id.level2:
                Toast.makeText(YoukuActivity.this, "level2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.icon_home:
                if (isShowLevel2) {
                    isShowLevel2 = false;
                    hideView(level2);
                    if (isShowLevel3) {
                        isShowLevel3 = false;
                        hideView(level3, 200);
                    }

                } else {
                    isShowLevel2 = true;
                    showView(level2);
                }

                break;
            case R.id.level1:
                Toast.makeText(YoukuActivity.this, "level1", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            if (isShowLevel1) {
                isShowLevel1 = false;
                hideView(level1);
                if (isShowLevel2) {
                    isShowLevel2 = false;
                    hideView(level2, 200);
                    if (isShowLevel3) {
                        isShowLevel3 = false;
                        hideView(level3, 400);
                    }

                }
            } else {
                isShowLevel1 = true;
                showView(level1);

                isShowLevel2 = true;
                showView(level2, 200);
            }

            return true;

        }


        return super.onKeyDown(keyCode, event);
    }
}
