package com.peedeep.library.thirdpart;

import android.os.SystemClock;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rick on 2019/4/26.
 * TODO
 */
public class RadioManager {

    private Set<RadioListener> listeners = new HashSet<>();

    public RadioManager() {
        //模拟后台上报
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (listeners != null) {
                    count++;
                    SystemClock.sleep(1000);
                    for (RadioListener listener : listeners) {
                        if (listener != null) {
                            listener.setFmFrequency(1.2f * count);
                        }
                    }
                }
            }
        }).start();
    }

    public void addListener(RadioListener radioListener) {
        if (listeners != null) {
            listeners.add(radioListener);
        }
    }

    public void remove(RadioListener radioListener) {
        if (listeners != null) {
            listeners.remove(radioListener);
        }
    }
}
