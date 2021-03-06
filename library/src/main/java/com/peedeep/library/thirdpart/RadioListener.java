package com.peedeep.library.thirdpart;

/**
 * Created by rick on 2019/4/1.
 * 模拟第三方提供的需要实现接口。
 */
public interface RadioListener {

    RadioResponse openRadio(String radioName);
    RadioResponse closeRadio(String radioName);
    void nextRadio(String radioName);
    void previousRadio(String radioName);
    boolean setAmFrequency(float frequency);
    boolean setFmFrequency(float frequency);
}
