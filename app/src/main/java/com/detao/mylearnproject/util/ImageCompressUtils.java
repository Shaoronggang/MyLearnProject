package com.detao.mylearnproject.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by shaoronggang on 2017/3/3.
 * Android 图片压缩的工具类
 */

public class ImageCompressUtils {

    /**
     * 第一：质量压缩方法：
     */

    public static Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，100表示不压缩，把压缩后的数据存放到baos中

        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) { //如果压缩后大于100kb，继续压缩
            baos.reset(); // baos进行重置，清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);// 这里压缩options%，把压缩后的数据存放到baos中

            options -= 10; //每次都减少10
        }

        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray()); //把压缩后的数据baos存放到ByteArrayOutputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null); // 把ByteArrayOutputStream 数据生成图片
        if (!image.isRecycled()) {
            image.recycle(); //图片资源进行相应的处理，不然容易造成相应的oom
            image = null;
        }

        return bitmap;
    }

    /**
     * 第二：图片按比例大小压缩方法：(根据路径获取图片并压缩)：
     */
    public static Bitmap getImage(String srcPath) {
        BitmapFactory.Options newOptions = new BitmapFactory.Options();
        //开始读入图片，此时把inJustDecodeBounds设回true
        newOptions.inJustDecodeBounds = true;
        /**
         * If set to true, the decoder will return null (no bitmap), but
         * the out... fields will still be set
         */
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, newOptions); //此时bitmap为空
        newOptions.inJustDecodeBounds = false;
        int w = newOptions.outWidth;
        int h = newOptions.outHeight;
        // 现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;// 这里设置高度为800f
        float ww = 480f;// 这里设置高度为480f
        // 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1; //1表示不缩放
        if (w > h && w > ww) {// 如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOptions.outWidth / ww);
        } else if (h > w && h > hh) { // 如果高度大的话根据高度固定大小缩放
            be = (int) (newOptions.outHeight / hh);
        }

        if (be <= 0)
            be = 1;
        /**
         *  example:SampleSize == 4 returns an image that is 1/4 the width/height of the original, and 1/16 the number of pixels.
         */
        newOptions.inSampleSize = be;
        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        bitmap = BitmapFactory.decodeFile(srcPath, newOptions);

        return compressImage(bitmap); //比例压缩之后，再进行相应的质量压缩
    }

    /**
     * 图片按比例大小压缩方法(根据Bitmap压缩图片)：
     */

    public static Bitmap comp(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        if (baos.toByteArray().length / 1024 > 1024) {  //判断如果图片大于1M,进行压缩避免生成图片是(BitmapFactory.decodeStream)时溢出
            baos.reset(); //重置baos，清空baos

            image.compress(Bitmap.CompressFormat.JPEG, 50, baos);//这里压缩50%,把压缩后的数据存放到baos中
        }

        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        BitmapFactory.Options newOpts = new BitmapFactory.Options();

        //开始读入图片，此时把newOpts.inJustDecodeBounds设置为true
        newOpts.inJustDecodeBounds = true;
        if (!image.isRecycled()) {
            image.recycle();
            image = null;
        }

        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);

        newOpts.inJustDecodeBounds = false;

        int w = newOpts.outWidth;
        int h = newOpts.outHeight;

        //设置一个手机的宽高的分辨率
        float ww = 1080f;
        float hh = 720f;
        //缩放比，由于缩放比是固定比例缩放，只用宽或者只用高其中一个数据进行计算即可
        int be = 1; //1 表示不缩放
        if (w > h && w > ww) { //如果宽度大的话，根据宽度固定大小的缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (h > w && h > hh) {
            be = (int) (newOpts.outHeight / hh);
        }

        newOpts.inSampleSize = be; //设置缩放比例

        /**
         * 重新读入图片，此时的 newOpts.inJustDecodeBounds = false
         */
        isBm = new ByteArrayInputStream(baos.toByteArray());
        bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);

        return compressImage(bitmap);// 压缩好比例大小后再进行质量压缩
    }

}
