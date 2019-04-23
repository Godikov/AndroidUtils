package com.humu.myutils;

import android.os.Handler;
import android.os.Message;

import java.util.HashMap;
import java.util.Map;

/**
 *  倒计时工具类，支持同时进行多个倒计时，并且添加监听。
 * Created by humu on 2019/4/23.
 */

public class TimerUtils {

    private static final Map<Integer,Integer> timerMap = new HashMap<>();
    private static final Map<Integer,CountDownTimerListener> listenerMap = new HashMap<>();

    private TimerUtils(){}

    /**
     * 开始倒计时
     * @param tag 用于标记倒计时
     * @param time 时间，单位秒
     * @param countDownTimerListener 倒计时监听
     */
    public static void start(int tag,int time,CountDownTimerListener countDownTimerListener){
        if(!timerMap.containsKey(tag)){
            TimerHandler handler = new TimerHandler();
            Message message = handler.obtainMessage(tag);
            if(time > 0){
                if(countDownTimerListener != null){
                    countDownTimerListener.onStartCountDown(tag);
                }
                handler.sendMessageDelayed(message,1000);
                timerMap.put(tag,time);
                listenerMap.put(tag,countDownTimerListener);
            }
        }
    }

    static class TimerHandler extends Handler{

        public TimerHandler(){

        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            if(listenerMap.containsKey(what)){
                CountDownTimerListener countDownTimerListener = listenerMap.get(what);
                if(countDownTimerListener != null){
                    if(timerMap.containsKey(what)){
                        Integer time = timerMap.get(what);
                        //返回当前时间
                        countDownTimerListener.onCount(what,time);
                        if(time > 0){
                            time--;
                            timerMap.put(what,time);
                        }
                        if(time == 0){
                            //倒计时结束
                            timerMap.remove(what);
                            listenerMap.remove(what);
                            countDownTimerListener.onCountDownEnd(what);
                        }else{
                            Message message = obtainMessage(what);
                            sendMessageDelayed(message,1000);
                        }
                    }
                }
            }
        }

    }

    /**
     * 倒计时监听
     */
    public interface CountDownTimerListener{
        //tag即what，用于标记是哪个倒计时
        void onStartCountDown(int tag);
        void onCount(int tag, int timeNow);
        void onCountDownEnd(int tag);
    }

}
