package com.humu.myutils;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by humu on 2019/1/19.
 */

public class ActivityManagerUtil {

    private static ActivityManagerUtil instance;

    private Stack<Activity> activityStack = new Stack<>();

    public static ActivityManagerUtil getInstance(){
        if(instance == null){
            instance = new ActivityManagerUtil();
        }
        return instance;
    }

    private ActivityManagerUtil(){

    }

    /**
     * 将Activity压入栈中
     * 在BaseActivity的onCreate()方法里调用
     * @param activity
     */
    public void pushActivity(Activity activity){
        activityStack.add(activity);
    }

    /**
     * 移除并结束指定的Activity
     * 在BaseActivity的onDestroy()方法里调用
     * @param activity
     */
    public void popActivity(Activity activity){
        if(activityStack != null && activityStack.size() > 0){
            if(activity != null){
                activityStack.remove(activity);
                activity.finish();
            }
        }
    }

    /**
     * 获取栈顶的Activity
     * @return
     */
    public Activity getLastActivity(){
        return activityStack.lastElement();
    }

    /**
     * 移除并结束所有的activity
     */
    public void finishAllActivity(){
        if(activityStack != null && activityStack.size() > 0){
            for(Activity activity: activityStack){
                if(activity != null){
                    activity.finish();
                }
            }
            activityStack.clear();
        }
    }

}
