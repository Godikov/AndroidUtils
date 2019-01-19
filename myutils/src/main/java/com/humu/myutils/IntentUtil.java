package com.humu.myutils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;

/**
 *  方便获取Intent中携带的数据
 * Created by humu on 2019/1/18.
 */

public class IntentUtil {

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

    public static boolean getBooleanExtra(Intent intent,String tag,boolean defaultValue){
        if(intent != null && intent.hasExtra(tag)){
            return intent.getBooleanExtra(tag,defaultValue);
        }
        return defaultValue;
    }

    public static double getDoubleExtra(Intent intent,String tag,double defaultValue){
        if(intent != null && intent.hasExtra(tag)){
            return intent.getDoubleExtra(tag,defaultValue);
        }
        return defaultValue;
    }

    public static double getFloatExtra(Intent intent,String tag,float defaultValue){
        if(intent != null && intent.hasExtra(tag)){
            return intent.getFloatExtra(tag,defaultValue);
        }
        return defaultValue;
    }

    public static long getLongExtra(Intent intent,String tag,long defaultValue){
        if(intent != null && intent.hasExtra(tag)){
            return intent.getLongExtra(tag,defaultValue);
        }
        return defaultValue;
    }

    public static<T extends Serializable> T getSerializableExtra(Intent intent, String tag){
        if(intent != null && intent.hasExtra(tag)){
            return (T) intent.getSerializableExtra(tag);
        }
        return null;
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

    public static float getBundleFloat(Intent intent,String tag,float defaultValue){
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null && bundle.containsKey(tag)){
                return bundle.getFloat(tag,defaultValue);
            }
        }
        return defaultValue;
    }

    public static double getBundleDouble(Intent intent,String tag,double defaultValue){
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null && bundle.containsKey(tag)){
                return bundle.getDouble(tag,defaultValue);
            }
        }
        return defaultValue;
    }

    public static double getBundleLong(Intent intent,String tag,long defaultValue){
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null && bundle.containsKey(tag)){
                return bundle.getLong(tag,defaultValue);
            }
        }
        return defaultValue;
    }

    public static<T extends Serializable> T getBundleSerializable(Intent intent,String tag){
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null && bundle.containsKey(tag)){
                return (T) bundle.getSerializable(tag);
            }
        }
        return null;
    }

    public static<T extends Parcelable> T getBundleParcelable(Intent intent, String tag){
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null && bundle.containsKey(tag)){
                return bundle.getParcelable(tag);
            }
        }
        return null;
    }

}
