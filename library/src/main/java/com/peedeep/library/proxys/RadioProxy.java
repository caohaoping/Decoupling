package com.peedeep.library.proxys;

import com.peedeep.library.finals.RadioFinal;
import com.peedeep.library.thirdpart.RadioResponse;
import com.peedeep.library.thirdpart.RadioListener;
import com.peedeep.library.util.Body;
import com.peedeep.library.util.Func;

/**
 * Created by rick on 2019/4/26.
 * 处理第三方回调的代理类，
 * 给中间层提供第三方回调的参数值及参数类型、返回值及返回类型。
 */
public class RadioProxy implements RadioListener {

    private final RadioFinal radioFinal;

    public RadioProxy(RadioFinal radioFinal) {
        this.radioFinal = radioFinal;
    }

    @Override
    public RadioResponse openRadio(final String radioName) {
        return radioFinal.openRadio(Body.hasParamHasResult(
                String.class,
                radioName,
                String.class,
                "好的",
                new Func<String, RadioResponse>() {
                    @Override
                    public RadioResponse apply(String s) {
                        return new RadioResponse(radioName, s);
                    }
                })
        );
    }

    @Override
    public RadioResponse closeRadio(final String radioName) {
        return radioFinal.closeRadio(Body.hasParamHasResult(
                String.class,
                radioName,
                String.class,
                "好的",
                new Func<String, RadioResponse>() {
                    @Override
                    public RadioResponse apply(String s) {
                        return new RadioResponse(radioName, s);
                    }
                })
        );
    }

    @Override
    public void nextRadio(String radioName) {
        radioFinal.nextRadio(Body.hasParamNoResult(String.class, radioName));
    }

    @Override
    public void previousRadio(String radioName) {
        radioFinal.previousRadio(Body.hasParamNoResult(String.class, radioName));
    }

    @Override
    public boolean setAmFrequency(float frequency) {
        return radioFinal.setAmFrequency(Body.hasParamHasResult(Float.class,
                frequency,
                Boolean.class,
                false,
                new Func<Boolean, Boolean>() {
                    @Override
                    public Boolean apply(Boolean aBoolean) {
                        return aBoolean;
                    }
                })
        );
    }

    @Override
    public boolean setFmFrequency(float frequency) {
        return radioFinal.setFmFrequency(Body.hasParamHasResult(
                Float.class,
                frequency,
                Boolean.class,
                false,
                new Func<Boolean, Boolean>() {
                    @Override
                    public Boolean apply(Boolean aBoolean) {
                        return aBoolean;
                    }
                })
        );
    }
}
