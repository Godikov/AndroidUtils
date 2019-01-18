package com.humu.myutils;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by humu on 2019/1/18.
 */

public class IntentUtil {

    /**
     * 跳转到Activity
     * @param context
     * @param tClass
     * @param <T>
     */
    public static<T extends Activity> void startActivity(Context context,Class<T> tClass){
        if(context != null){
            Intent intent = new Intent(context,tClass);
            context.startActivity(intent);
        }
    }

    /**
     * 跳转到Activity
     * @param activity
     * @param tClass
     * @param <T>
     */
    public static<T extends Activity> void startActivityForResult(Activity activity,Class<T> tClass,
                                                                  int requestCode){
        if(activity != null){
            Intent intent = new Intent(activity,tClass);
            activity.startActivityForResult(intent,requestCode);
        }
    }

    /**
     * 启动Service
     * @param context
     * @param tClass
     * @param <T>
     */
    public static<T extends Service> void startService(Context context, Class<T> tClass){
        if(context != null){
            Intent intent = new Intent(context,tClass);
            context.startService(intent);
        }
    }

    public static String getStringExtra(Intent intent,String tag){
        String result = "";
        if(intent != null && intent.hasExtra(tag)){
            result = intent.getStringExtra(tag);
        }
        return result;
    }

    public static int getIntExtra(Intent intent,String tag,int defaultValue){
        int result = 0;
        if(intent != null && intent.hasExtra(tag)){
            result = intent.getIntExtra(tag,defaultValue);
        }
        return result;
    }

    public static<T> T getParcelableExtra(Intent intent,String tag){
        T result = null;
        if(intent != null && intent.hasExtra(tag)){
            result = intent.getParcelableExtra(tag);
        }
        return result;
    }

    public static String getBundleString(Intent intent,String tag){
        String result = "";
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null && bundle.containsKey(tag)){
                result = bundle.getString(tag);
            }
        }
        return result;
    }

    public static int getBundleInt(Intent intent,String tag){
        int result = 0;
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null && bundle.containsKey(tag)){
                result = bundle.getInt(tag);
            }
        }
        return result;
    }

}
