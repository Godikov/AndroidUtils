package com.humu.myutils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Toast工具类，不用判断线程
 * Created by humu on 2019/1/19.
 */

public class ToastUtil {

    private ToastUtil(){}

    private static Toast toast;

    public static Handler mHandler = new Handler(Looper.getMainLooper());

    public static void showToast(Context context,String text)
    {
        if(context != null && !TextUtils.isEmpty(text)){
            showToast(context,text, Toast.LENGTH_SHORT);
        }
    }

    public static void showToastLong(Context context,String text)
    {
        if(context != null && !TextUtils.isEmpty(text)){
            showToast(context,text, Toast.LENGTH_LONG);
        }
    }

    private static void showToast(final Context context, final String text, final int duration)
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            show(context,text, duration);
        } else
        {
            mHandler.post(new Runnable()
            {
                @Override
                public void run()
                {
                    show(context,text, duration);
                }
            });
        }
    }

    private static void show(Context context,String text, int duration)
    {
        if (TextUtils.isEmpty(text))
        {
            return;
        }
        if (toast != null)
        {
            toast.cancel();
        }
        toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
