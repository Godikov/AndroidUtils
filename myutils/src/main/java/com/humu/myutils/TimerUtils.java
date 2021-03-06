package com.humu.myutils;

import android.os.Handler;
import android.os.Message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  倒计时工具类，支持同时进行多个倒计时，并且添加监听。
 * Created by humu on 2019/4/23.
 */

public class TimerUtils {

    private static final Map<Integer,TimerHandler> handlerMap = new ConcurrentHashMap<>();
    private static final Map<Integer,Integer> timerMap = new ConcurrentHashMap<>();
    private static final Map<Integer,CountDownTimerListener> listenerMap = new ConcurrentHashMap<>();

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
            synchronized (handlerMap){
                handlerMap.put(tag,handler);
            }
            Message message = handler.obtainMessage(tag);
            if(time > 0){
                if(countDownTimerListener != null){
                    countDownTimerListener.onStartCountDown(tag);
                }
                handler.sendMessageDelayed(message,1000);
                synchronized (timerMap){
                    timerMap.put(tag,time);
                }
                synchronized (listenerMap){
                    listenerMap.put(tag,countDownTimerListener);
                }
            }
        }
    }

    static class TimerHandler extends Handler{

        public TimerHandler(){

        }

        @Override
        public synchronized void handleMessage(Message msg) {
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
                            removeTag(what);
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

    private static void removeTag(int tag){
        if(timerMap.containsKey(tag)){
            synchronized (timerMap){
                timerMap.remove(tag);
            }
        }
        if(listenerMap.containsKey(tag)){
            synchronized (listenerMap){
                listenerMap.remove(tag);
            }
        }
        if(handlerMap.containsKey(tag)){
            synchronized (handlerMap){
                handlerMap.remove(tag);
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

    /**
     * 停止倒计时（指定的倒计时）
     * @param tag
     */
    public synchronized static void stop(int tag){
        if(handlerMap.containsKey(tag)){
            TimerHandler handler = handlerMap.get(tag);
            if(handler != null && handler.hasMessages(tag)){
                handler.removeMessages(tag);
            }
            removeTag(tag);
        }
    }

    /**
     * 停止所有倒计时
     */
    public synchronized static void stopAll(){
        if(handlerMap.size() > 0){
            for(int tag: handlerMap.keySet()){
                stop(tag);
            }
        }
    }

}
