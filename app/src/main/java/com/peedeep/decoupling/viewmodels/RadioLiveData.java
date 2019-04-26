package com.peedeep.decoupling.viewmodels;

import android.arch.lifecycle.LiveData;

import com.peedeep.decoupling.data.Radio;
import com.peedeep.library.middles.RadioMiddle;
import com.peedeep.library.util.Body;

/**
 * Created by rick on 2019/4/26.
 * TODO
 */
public class RadioLiveData extends LiveData<Radio> {

    private final RadioMiddle radioMiddle;

    public RadioLiveData() {
        radioMiddle = new RadioMiddle() {
            @Override
            public <T, X, R> X openRadio(Body<T, X, R> body) {
                String radioName = (String) Body.mapParam(body);
                postValue(new Radio(radioName, -1));
                return Body.mapReturn("已经为您打开" + radioName, body);
            }

            @Override
            public <T, X, R> X closeRadio(Body<T, X, R> body) {
                String radioName = (String) Body.mapParam(body);
                postValue(new Radio(radioName, -1));
                return Body.mapReturn("已经为您关闭" + radioName, body);
            }

            @Override
            public <T, X, R> X nextRadio(Body<T, X, R> body) {
                String radioName = (String) Body.mapParam(body);
                postValue(new Radio(radioName, -1));
                return null;
            }

            @Override
            public <T, X, R> X previousRadio(Body<T, X, R> body) {
                String radioName = (String) Body.mapParam(body);
                postValue(new Radio(radioName, -1));
                return null;
            }

            @Override
            public <T, X, R> X setAmFrequency(Body<T, X, R> body) {
                float frequency = (Float) Body.mapParam(body);
                postValue(new Radio(null, frequency));
                return Body.mapReturn(true, body);
            }

            @Override
            public <T, X, R> X setFmFrequency(Body<T, X, R> body) {
                float frequency = (Float) Body.mapParam(body);
                postValue(new Radio(null, frequency));
                return Body.mapReturn(true, body);
            }
        };
    }

    @Override
    protected void onActive() {
        radioMiddle.subscribe();
    }

    @Override
    protected void onInactive() {
        radioMiddle.unSubscribe();
    }
}
