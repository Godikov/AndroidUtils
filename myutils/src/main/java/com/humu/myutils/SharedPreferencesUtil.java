package com.humu.myutils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/**
 * Created by humu on 2019/1/19.
 */

public class SharedPreferencesUtil {

    public static void setString(Context context,String key,String value){
        if(!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)){
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            sharedPreferences.edit().putString(key,value).apply();
        }
    }

    public static String getString(Context context,String key,String defaultValue){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(key,defaultValue);
    }

    public static void setInt(Context context,String key,int value){
        if(!TextUtils.isEmpty(key)){
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            sharedPreferences.edit().putInt(key,value).apply();
        }
    }

    public static int getInt(Context context,String key,int defaultValue){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(key,defaultValue);
    }

    public static void setFloat(Context context,String key,float value){
        if(!TextUtils.isEmpty(key)){
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            sharedPreferences.edit().putFloat(key,value).apply();
        }
    }

    public static Float getFloat(Context context,String key,Float defaultValue){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getFloat(key,defaultValue);
    }

    public static void setLong(Context context,String key,long value){
        if(!TextUtils.isEmpty(key)){
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            sharedPreferences.edit().putLong(key,value).apply();
        }
    }

    public static Long getLong(Context context,String key,long defaultValue){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getLong(key,defaultValue);
    }

    public static void setBoolean(Context context,String key,boolean value){
        if(!TextUtils.isEmpty(key)){
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            sharedPreferences.edit().putBoolean(key,value).apply();
        }
    }

    public static boolean getBoolean(Context context,String key,boolean defaultValue){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(key,defaultValue);
    }

    public static boolean hasKey(Context context,String key){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.contains(key);
    }

    public static void clearData(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        sharedPreferences.edit().clear().apply();
    }

}
