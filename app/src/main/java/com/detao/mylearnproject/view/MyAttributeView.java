package com.detao.mylearnproject.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.detao.mylearnproject.R;

/**
 * Created by shaoronggang on 2017/5/19.
 */

public class MyAttributeView extends View {
    private String myName;
    private int myAge;
    private Bitmap myBg;


    public MyAttributeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        //获取属性的三种方式
        //1.通过命名空间获取
        String name = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto","my_name");
        String age = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto","my_age");
        String bg = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto","my_bg");

        System.out.println("age=="+age+",name=="+name+",bg==="+bg);

        //2.通过遍历来获取属性
        for (int i = 0; i <attrs.getAttributeCount() ; i++) {
            System.out.println(attrs.getAttributeName(i) + "=====" + attrs.getAttributeValue(i));
        }

        //3.使用系统工具，获取属性
        TypedArray typedArray =  context.obtainStyledAttributes(attrs, R.styleable.MyAttrbuteView);
        for (int i = 0; i <typedArray.getIndexCount() ; i++) {
            int index = typedArray.getIndex(i);
            switch (index) {
                case  R.styleable.MyAttrbuteView_my_name:
                myName = typedArray.getString(index);
                    break;
                case R.styleable.MyAttrbuteView_my_age:
                    myAge = typedArray.getInt(index,0);
                    break;
                case R.styleable.MyAttrbuteView_my_bg:
                    //将drawable文件转变成相应的bitmap文件
                    Drawable drawable = typedArray.getDrawable(index);
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                    myBg = bitmapDrawable.getBitmap();
                    break;
            }
        }

        //记得收回，不然会造成内存泄漏
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        canvas.drawText(myName + "----" + myAge,50,50,paint);
        canvas.drawBitmap(myBg,50,50,paint);
    }
}
